package ElitePerformance.edu.Service;

import ElitePerformance.edu.Dto.PerformanceRequestDTO;
import ElitePerformance.edu.Dto.PerformanceResponseDTO;
import ElitePerformance.edu.Entity.Employee;
import ElitePerformance.edu.Repository.BonusRepository;
import ElitePerformance.edu.Repository.EmployeeRepository;
import ElitePerformance.edu.Repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PerformanceService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PerformanceRepository performanceRepository;

    @Autowired
    private BonusRepository bonusRepository;

    @Transactional
    public PerformanceResponseDTO calculateBonus(
            PerformanceRequestDTO dto
    ) {

        validate(dto);

        Employee employee =
                employeeRepository.findById(dto.getEmployeeId());

        int totalScore =
                dto.getTaskCompletion()
                        + dto.getAttendance()
                        + dto.getTeamCollaboration()
                        + dto.getProblemSolving()
                        + dto.getCommunicationSkill()
                        + dto.getLeadership()
                        + dto.getClientSatisfaction();

        String category;
        double percentage;

        if(totalScore >= 90){
            category = "Gold Tier";
            percentage = 20;
        }
        else if(totalScore >= 75){
            category = "Silver Tier";
            percentage = 12;
        }
        else if(totalScore >= 60){
            category = "Bronze Tier";
            percentage = 5;
        }
        else{
            category = "No Tier";
            percentage = 0;
        }

        double bonusAmount =
                employee.getBaseSalary()
                        * percentage / 100;

        double totalCompensation =
                employee.getBaseSalary()
                        + bonusAmount;

        performanceRepository.saveReview(dto, totalScore);

        bonusRepository.saveBonus(
                employee.getEmployeeId(),
                dto.getReviewYear(),
                totalScore,
                category,
                percentage,
                bonusAmount,
                totalCompensation
        );

        return new PerformanceResponseDTO(
                employee.getEmployeeId(),
                employee.getName(),
                totalScore,
                category,
                percentage,
                bonusAmount,
                totalCompensation
        );
    }

    private void validate(PerformanceRequestDTO dto){

        if(dto.getTaskCompletion() > 25)
            throw new RuntimeException("Task Completion invalid");

        if(dto.getAttendance() > 15)
            throw new RuntimeException("Attendance invalid");

        if(dto.getTeamCollaboration() > 15)
            throw new RuntimeException("Team Collaboration invalid");

        if(dto.getProblemSolving() > 15)
            throw new RuntimeException("Problem Solving invalid");

        if(dto.getCommunicationSkill() > 10)
            throw new RuntimeException("Communication invalid");

        if(dto.getLeadership() > 10)
            throw new RuntimeException("Leadership invalid");

        if(dto.getClientSatisfaction() > 10)
            throw new RuntimeException("Client Satisfaction invalid");
    }
}