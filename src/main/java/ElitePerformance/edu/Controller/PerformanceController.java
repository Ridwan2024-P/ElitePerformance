package ElitePerformance.edu.Controller;



import ElitePerformance.edu.Dto.PerformanceRequestDTO;
import ElitePerformance.edu.Dto.PerformanceResponseDTO;
import ElitePerformance.edu.Service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/calculate")
    public PerformanceResponseDTO calculate(
            @RequestBody PerformanceRequestDTO dto
    ) {

        return performanceService.calculateBonus(dto);
    }
}