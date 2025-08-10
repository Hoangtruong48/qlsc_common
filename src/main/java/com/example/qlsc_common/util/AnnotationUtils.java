package com.example.qlsc_common.util;

import com.dts.tsdc.common.domain.document.hoso.HocSinh;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class AnnotationUtils {
    public static void printAnnotationDiffs(Class<?> clazz, boolean includeSup) {
        Class<?> current = clazz;
        int count = 0;
        while (current != null) {
            for (Field f : current.getDeclaredFields()) {
                count++;
                // Bỏ qua hằng hoặc field synthetic
                if (Modifier.isStatic(f.getModifiers()) || f.isSynthetic()) continue;

                JsonProperty jp = f.getAnnotation(JsonProperty.class);
                org.springframework.data.mongodb.core.mapping.Field mongo
                        = f.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);

                String jpVal = jp    != null ? jp.value()    : "<không có>";
                String mgVal = mongo != null ? mongo.value() : "<không có>";

                System.out.printf("Field %-15s | @JsonProperty = %-12s | @Field = %-12s | %s%n",
                        f.getName(), jpVal, mgVal,
                        jpVal.equals(mgVal) ? "✅ Giống" : "❌ Khác");
            }
            current = includeSup ? current.getSuperclass() : null;
        }
        System.out.println("So field = " + count);
    }

    public static void exportAnnotationDiffs(Class<?> clazz,
                                             boolean includeSup,
                                             String filePath) throws IOException {

        try (Workbook wb = new XSSFWorkbook();
             FileOutputStream out = new FileOutputStream(filePath)) {

            Sheet sheet = wb.createSheet("Diffs");
            // ----- header -----
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("Field Name");
            header.createCell(1).setCellValue("@JsonProperty");
            header.createCell(2).setCellValue("@Field (Mongo)");

            int rowIdx = 1;
            Class<?> current = clazz;
            while (current != null) {
                for (Field f : current.getDeclaredFields()) {
                    if (Modifier.isStatic(f.getModifiers()) || f.isSynthetic()) continue;

                    JsonProperty jp = f.getAnnotation(JsonProperty.class);
                    org.springframework.data.mongodb.core.mapping.Field mongo    = f.getAnnotation(org.springframework.data.mongodb.core.mapping.Field.class);

                    Row row = sheet.createRow(rowIdx++);
                    row.createCell(0).setCellValue(f.getName());
                    row.createCell(1).setCellValue(jp    != null ? jp.value()    : "");
                    row.createCell(2).setCellValue(mongo != null ? mongo.value() : "");
                }
                current = includeSup ? current.getSuperclass() : null;
            }

            // Tự động fit chiều rộng cột
            for (int i = 0; i < 3; i++) sheet.autoSizeColumn(i);
            wb.write(out);
        }
    }

    public static void main(String[] args) throws IOException {
        exportAnnotationDiffs(HocSinh.class, true, "ten_bien_hoc_sinh.xlsx");
    }
}
