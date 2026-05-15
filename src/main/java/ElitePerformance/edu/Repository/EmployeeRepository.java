package ElitePerformance.edu.Repository;



import ElitePerformance.edu.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public Employee findById(Long id) {

        String sql = """
            SELECT * FROM employees
            WHERE employee_id=:id
        """;

        return jdbcTemplate.queryForObject(
                sql,
                Map.of("id", id),
                (rs, rowNum) -> {
                    Employee e = new Employee();
                    e.setEmployeeId(rs.getLong("employee_id"));
                    e.setName(rs.getString("name"));
                    e.setDesignation(rs.getString("designation"));
                    e.setBaseSalary(rs.getDouble("base_salary"));
                    e.setRole(rs.getString("role"));
                    return e;
                }
        );
    }
}