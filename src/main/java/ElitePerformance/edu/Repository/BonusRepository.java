package ElitePerformance.edu.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class BonusRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void saveBonus(
            Long employeeId,
            int reviewYear,
            int totalScore,
            String category,
            double percentage,
            double bonusAmount,
            double totalCompensation
    ) {

        String sql = """
            INSERT INTO bonus_records(
                employee_id,
                review_year,
                total_kpi_score,
                category,
                bonus_percentage,
                bonus_amount,
                total_compensation
            )
            VALUES(
                :employeeId,
                :reviewYear,
                :totalScore,
                :category,
                :percentage,
                :bonusAmount,
                :totalCompensation
            )
        """;

        jdbcTemplate.update(sql, Map.of(
                "employeeId", employeeId,
                "reviewYear", reviewYear,
                "totalScore", totalScore,
                "category", category,
                "percentage", percentage,
                "bonusAmount", bonusAmount,
                "totalCompensation", totalCompensation
        ));
    }
}