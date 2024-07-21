package utils;

import java.io.File;

public class TestDataMapper extends Parameters {

	public static String ECOMMERCEINPUT = "purchaseOrder.xlsx";

	public static String getEcommerce() {

		propLoad();

		return inputPath + File.separator + ECOMMERCEINPUT;

	}
}
