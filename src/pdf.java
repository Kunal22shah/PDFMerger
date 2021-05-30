import org.apache.pdfbox.io.MemoryUsageSetting;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class pdf {

	public static void main(String[] args) throws IOException {

		System.out.println("Enter the number of files you want to merge: ");

		Scanner sc = new Scanner(System.in);

		int nb = sc.nextInt();

		String[] names = new String[nb];
		File[] files = new File[nb];

		// Instantiating PDFMergerUtility class

		PDFMergerUtility obj = new PDFMergerUtility();

		// Setting the destination file path

		obj.setDestinationFileName("/Users/kunal/Desktop/merged.pdf");

		// loading all the pdf files we wish to merge

		for (int i = 0; i < nb; i++) {
			System.out.println("Enter the name of File " + (i + 1) + " :");

			names[i] = sc.next();
			files[i] = new File("/Users/kunal/Desktop/" + names[i]);

			// Add all source files, to be merged
			obj.addSource(files[i]);
			// Merging documents
			obj.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

		}

		System.out.println("Files Merged! ");
	}
}