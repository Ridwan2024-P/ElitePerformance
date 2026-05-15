package ElitePerformance.edu.Dto;

import lombok.Data;

@Data
public class PerformanceRequestDTO {

    private Long employeeId;
            private int reviewYear;
    private int taskCompletion;
    private int attendance;
         private int teamCollaboration;
    private int problemSolving;
          private int communicationSkill;
    private int leadership;
    private int clientSatisfaction;
}