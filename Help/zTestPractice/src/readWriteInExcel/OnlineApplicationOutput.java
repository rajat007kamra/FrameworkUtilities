package readWriteInExcel;

import java.text.DecimalFormat;

import utilities.CommonFunctions;
import utilities.DeclareVariable;

public class OnlineApplicationOutput 
{	
	public static void cccApplicationOutput()
	{
		DecimalFormat df = new DecimalFormat("#0.00");
		
//OutPut Values Getting from Application
		
		//Summary of Fees
		DeclareVariable.labelSummaryFee = CommonFunctions.commonLabelText("Summary of Fees", "Summary of Fees");
		
		//Output- Sales Tax Total
		DeclareVariable.labelTotalSalesFeesDataValue = CommonFunctions.commonLabelText("totalSalesFeesDataValue", "Sales Tax Total");
		
		//Output- Sales Tax
		DeclareVariable.labelSaleTax = CommonFunctions.commonLabelText("Sales Tax", "Sales Tax");
    	
		//Output- Additional Sale Tax/Use Tax
		DeclareVariable.labelAdditionalSalesTax = CommonFunctions.commonLabelText("Additional sales tax/Use tax", "Additional Sale Tax/Use Tax");
    	
    	//Output- Location Rate
		DeclareVariable.labelLocationRate = CommonFunctions.commonLabelText("Location Rate", "Location Rate");
    	
		//Output- Other Taxes and Fees
    	DeclareVariable.labelOtherTaxesAndFees = CommonFunctions.commonLabelText("Other Taxes and Fees", "Other Taxes and Fees");
    	
    	//Output- RTA Total
    	DeclareVariable.labelTotalRTA = CommonFunctions.commonLabelText("totalTRA", "RTA Total");
    	
    	//Output- Total Title Fees
    	DeclareVariable.labelTitleFeesTotal = CommonFunctions.commonLabelText("totalTitleFee", "Title Fees");
    	
    	//Output- Application Fee - Certificate of Title
    	DeclareVariable.labelApplicationFee = CommonFunctions.commonLabelText("Application Fee - Certificate of Title", "Application Fee - Certificate of Title");
    	
    	//Output- Emergency Medical Services
    	DeclareVariable.labelEmergencyMedicalServices = CommonFunctions.commonLabelText("Emergency Medical Services", "Emergency Medical Services");
    	
    	//Output- Title Filing Fee
		DeclareVariable.labelTitleFilingFee = CommonFunctions.commonLabelText("Title filing fee", "Title Filing Fee");
		
		//Output- Registration Fees Total
		DeclareVariable.labelRegistrationFeeTotal = CommonFunctions.commonLabelText("totalRegFee", "Registration Fees Total");
		
		//Output- Registration Filing Fee
		DeclareVariable.labelRegFillingFee = CommonFunctions.commonLabelText("Registration filing fee", "Registration Filing Fee");
		
		//Output- Vehicle Type Fee
    	DeclareVariable.labelVehicleTypeFee = CommonFunctions.commonLabelText("Vehicle type fee", "Vehicle Type Fee");
    	
    	//Output- License Plate Technology Fee
    	DeclareVariable.labelLicensePlateTechnologyFee = CommonFunctions.commonLabelText("License plate technology fee", "License Plate Technology Fee");
    	
    	//Output - License Service Fee
    	DeclareVariable.labelLicenseServiceFee = CommonFunctions.commonLabelText("License service fee", "License Service Fee");
    	
    	//Output- Vehicle Weight Fee
    	DeclareVariable.labelVehicleWeightFee = CommonFunctions.commonLabelText("Vehicle weight fee", "Vehicle Weight Fee");
    	
    	//Output- License Fee By Weight
		DeclareVariable.labelLicenseFeeByWeight = CommonFunctions.commonLabelText("License fee by weight", "License Fee By Weight");
		
		//Output- Monthly Declared Gross Weight License Fees
    	DeclareVariable.labelMonthlyDeclaredGrossWeightLicenseFees = CommonFunctions.commonLabelText("Monthly declared gross weight license fees", "Monthly Declared Gross Weight License Fees");
 
    	//Output- Freight Project Fee
    	DeclareVariable.labelFreightProjectFee = CommonFunctions.commonLabelText("freight project fee", "Freight Project Fee");
	}
}