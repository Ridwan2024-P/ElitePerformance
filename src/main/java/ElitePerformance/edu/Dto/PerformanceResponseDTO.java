package ElitePerformance.edu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerformanceResponseDTO {

    private Long employeeId;
       private String employeeName;

    private int totalKpiScore;

    private String category;
        private double bonusPercentage;
    private double bonusAmount;
    private double totalCompensation;
}