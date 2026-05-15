package ElitePerformance.edu.Controller;

import ElitePerformance.edu.Dto.PerformanceRequestDTO;
import ElitePerformance.edu.Dto.PerformanceResponseDTO;
import ElitePerformance.edu.Service.PerformanceService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/performances")
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @PostMapping("/calculate")
    @PreAuthorize("hasRole('MANAGER')")
    public PerformanceResponseDTO calculate(
            @Valid @RequestBody PerformanceRequestDTO dto
    ) {
        return performanceService.calculateBonus(dto);
    }
}