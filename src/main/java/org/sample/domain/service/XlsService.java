package org.sample.domain.service;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

@Service
public class XlsService {
	public void xlsTest() {
		//エクセルファイルへアクセスするためのオブジェクト
		Workbook excel;
		try {
			excel = WorkbookFactory.create(
					new File("/Applications/Eclipse_4.8.0.app/Contents/workspace/jartest/work/excel/test.xlsx"));

			// シート名がわかっている場合
			Sheet sheet = excel.getSheet("シート1");

			//0行目
			Row row = sheet.getRow(0);

			//0番目のセル
			Cell cell = row.getCell(0);

			//文字列の取得
			String value = cell.getStringCellValue();

			//取得した文字列の表示
			System.out.println(value);
			excel.close();
		} catch (EncryptedDocumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}