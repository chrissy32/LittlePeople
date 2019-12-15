package littlepeople.application.service;


import littlepeople.application.model.Report;
import littlepeople.application.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ReportService {

    @Autowired
    ReportRepository reportRepository;


    public void addReport(Report report) {
        reportRepository.save(report);
    }
}
