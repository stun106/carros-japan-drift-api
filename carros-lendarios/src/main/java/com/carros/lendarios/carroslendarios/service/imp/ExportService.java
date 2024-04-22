package com.carros.lendarios.carroslendarios.service.imp;

import com.carros.lendarios.carroslendarios.model.Garagem;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportService {
    @Autowired
    private GaragemService garagemService;

    public void exportXlsx (HttpServletRequest request){
        List<Garagem> garagens = garagemService.buscarTodasGaragens();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
    }
}
