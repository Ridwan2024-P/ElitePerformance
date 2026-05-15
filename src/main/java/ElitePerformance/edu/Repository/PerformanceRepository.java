package ElitePerformance.edu.Repository;



import ElitePerformance.edu.Dto.PerformanceRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PerformanceRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void saveReview(PerformanceRequestDTO dto, int totalScore) {

        String sql = """
            INSERT INTO performance_reviews(
                employee_id,
                review_year,
                task_completion,
                attendance,
                team_collaboration,
                problem_solving,
                communication_skill,
                leadership,
                client_satisfaction,
                total_score
            )
            VALUES(
                :employeeId,
                :reviewYear,
                :taskCompletion,
                :attendance,
                :teamCollaboration,
                :problemSolving,
                :communicationSkill,
                :leadership,
                :clientSatisfaction,
                :totalScore
            )
        """;

        jdbcTemplate.update(sql, Map.of(
                "employeeId", dto.getEmployeeId(),
                "reviewYear", dto.getReviewYear(),
                "taskCompletion", dto.getTaskCompletion(),
                "attendance", dto.getAttendance(),
                "teamCollaboration", dto.getTeamCollaboration(),
                "problemSolving", dto.getProblemSolving(),
                "communicationSkill", dto.getCommunicationSkill(),
                "leadership", dto.getLeadership(),
                "clientSatisfaction", dto.getClientSatisfaction(),
                "totalScore", totalScore
        ));
    }
}