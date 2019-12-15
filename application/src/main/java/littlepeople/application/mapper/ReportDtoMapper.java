package littlepeople.application.mapper;

import littlepeople.application.dto.ReportDto;
import littlepeople.application.model.Report;
import org.springframework.stereotype.Component;

@Component
public class ReportDtoMapper extends  AbstractMapper<Report, ReportDto> {
    @Override
    public Report convertDtoToModel(ReportDto reportDto) {
        return new Report(reportDto.getActivity(),reportDto.getText());
    }

    @Override
    public ReportDto convertModelToDto(Report report) {
        return null;
    }
}
