package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	
	//Data Providers 1
		@DataProvider(name="LoginData")
		public String [][] getData() throws IOException{
		
		String path = ".\\testData\\Opencart_LoginData.xlsx"; // Taking xl file from the path
		
		ExcelUtility xlutil = new ExcelUtility(path); // create and object for XLUtility 
		
		int totalrows = xlutil.getRowCount("sheet1");
		int totalcols = xlutil.getCellCount("sheet1", 1);
		
		String logindata [][] = new String[totalrows][totalcols]; // create two dimension array 
		
		for(int i = 1; i<totalrows ; i++ ) {					// read the data from xl storing i 
			
				for(int j = 0; j<totalcols; j++) {	//0			// i row j is col
					
					logindata [i-1][j]= xlutil.getCellData("sheet1", i, j); //1,0
			}
		}
		return logindata; // returning two dimension array
		}
		
		//dataProvider 2
		
		//dataProvider 3
		
    }
