package com.example.PPSIntershipRESTapi.repository;

import com.example.PPSIntershipRESTapi.entity.Pasantia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface PasantiaRepository extends CrudRepository<Pasantia, Integer> {
    @Query(
            value = "SELECT *\n" +
                    "FROM Pasantia\n" +
                    "WHERE intershipstatuscode = :statuscode",
            nativeQuery = true
    )
    public List<Pasantia> getPasantiasByStatusCode(@Param("statuscode") Integer statuscode);

    @Query(
            value = "SELECT Pa.*\n" +
                    "FROM Pasantia AS Pa, Users AS U\n" +
                    "WHERE Pa.intershipstatuscode = :statuscode\n" +
                    "AND U.userDNI = Pa.studentDNI\n" +
                    "AND U.schoolName = :schoolName",
            nativeQuery = true
    )
    public List<Pasantia> getPasantiasByStatusCodeAndSchool(@Param("statuscode") Integer statuscode, @Param("schoolName") String schoolName);
    @Query(
            value = "SELECT crearPropuestaPasantia(:intershiptitle, :enterpriseId, :intershipstartdate, :studentDNI, :corporateTutorDNI, :intershipCompletionDate)",
            nativeQuery = true
    )
    public Boolean createPasantia (@Param("intershiptitle") String IntershipTitle, @Param("enterpriseId") Integer enterpriseId, @Param("intershipstartdate") Date intershipStartDate, @Param("studentDNI") String studentDNI, @Param("corporateTutorDNI") String corporateTutorDNI,@Param("intershipCompletionDate") Date intershipCompletionDate);
    @Query(
            value = "SELECT cambiarEstadoPasantia(:intershipId, :intershipStatusCode)",
            nativeQuery = true
    )
    public Boolean changeStatus (@Param("intershipId") Integer intershipId, @Param("intershipStatusCode") Integer intershipStatusCode);

    @Query(
            value = "SELECT evaluarPropuestaPasantia(:intershipId, :intershipStatusCode, :schoolCouncilId, :schoolCouncilDecision, :academicTutorDNI)",
            nativeQuery = true
    )
    public Boolean evaluateIntershipProposal (@Param("intershipId") Integer intershipId, @Param("intershipStatusCode") Integer intershipStatusCode, @Param("schoolCouncilId") String schoolCouncilId, @Param("schoolCouncilDecision") String schoolCouncilDecision, @Param("academicTutorDNI") String academicTutorDNI);

    @Query(
            value = "SELECT evaluarInformePasantia(:intershipId, :academicTutorEvaluation, :corporateTutorEvaluation)",
            nativeQuery = true
    )
    public Boolean evaluateIntershipReport(@Param("intershipId") Integer intershipId, @Param("academicTutorEvaluation") Integer academicTutorEvaluation, @Param("corporateTutorEvaluation") Integer corporateTutorEvaluation);

    @Query(
            value = "SELECT *\n" +
                    "FROM Pasantia\n" +
                    "WHERE intershipId = :intershipId",
            nativeQuery = true
    )
    public Pasantia getPasantiaById(@Param("intershipId") Integer intershipId);

    @Query(
            value = "SELECT *\n" +
                    "FROM pasantia\n" +
                    "WHERE studentDNI = :studentDNI\n" +
                    "AND intershipstatuscode NOT IN (400,401)",
            nativeQuery = true
    )
    public Pasantia getStudentCurrentPasantia(@Param("studentDNI") String studentDNI);

    @Query(
            value = "SELECT *\n" +
                    "FROM (\n" +
                    "    SELECT Est.studentDNI\n" +
                    "    FROM students AS Est \n" +
                    "    LEFT JOIN Pasantia ON Est.studentDNI = Pasantia.studentDNI\n" +
                    "    WHERE Pasantia.studentDNI IS NULL\n" +
                    "\n" +
                    "    UNION\n" +
                    "\n" +
                    "    SELECT Est.studentDNI\n" +
                    "\tFROM students AS Est\n" +
                    "\tWHERE (SELECT COUNT(*) FROM Pasantia  AS Pa WHERE Pa.studentDNI = Est.studentDNI AND Pa.intershipstatuscode NOT IN (400,100,401)) = 0\n" +
                    "\t\n" +
                    ") AS TableSt\n" +
                    "GROUP BY studentDNI",
            nativeQuery = true
    )
    public List<String> getStudentForProposalPending();

}
