package selfCreatedHTMLReport;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class Dynmic_HTML {

	File file = new File("S://MobilePhoneLists.html");
	FileWriter fileWriter = null;
	BufferedWriter bufferedWriter = null;
	
	
	    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    
	    
	   
public  void createHTML() throws Exception {



fileWriter = new FileWriter(file);
bufferedWriter = new BufferedWriter(fileWriter);

String htmlPage = "<html><body style=’background-color:#ccc’><b><h3><center>Report Created At<br><u>"+strDate+"</u></center></h3></b>" ;

bufferedWriter.write(htmlPage);
}

public void appendHTMLHeader() throws Exception
{

//bufferedWriter.append("<strong><h4>Mobile Phone Companies</h4></strong><ul><li><a href="+"http:\\www.google.com"+">google_link</a>"+"</li><li>Samsung</li><li>Nokia</li></ul></body></html>");


bufferedWriter.append("<table width="+"400"+" border="+"4"+">"+"<tr><td bgcolor="+"#00FFFF"+">TestCase</td><td bgcolor="+"#00FFFF"+">Keyword</td><td bgcolor="+"#00FFFF"+">Results</td><td bgcolor="+"#00FFFF"+">CheckScreenshot</td></tr>");

System.out.println("Html page updated");

}

public void appendHTMLRows(String TestCase,String Keyword,String Results,String URL,String FinalURL) throws Exception
{

//bufferedWriter.append("<strong><h4>Mobile Phone Companies</h4></strong><ul><li><a href="+"http:\\www.google.com"+">google_link</a>"+"</li><li>Samsung</li><li>Nokia</li></ul></body></html>");
	//&nbsp;

bufferedWriter.append("<table width="+"400"+" border="+"4"+">"+"<tr><td bgcolor="+"#00FFFF"+">"+TestCase+"</td><td bgcolor="+"#00FFFF"+">"+Keyword+"</td><td bgcolor="+"#00FFFF"+">"+Results+"</td><td bgcolor="+"#00FFFF"+"><a href="+FinalURL+">FindScreenShot</a>"+"</td></tr></body></table></html>");

System.out.println("Html page updated");

}

public void FLUSHBUFFER() throws Exception
{
	bufferedWriter.flush();
	fileWriter.flush();

	bufferedWriter.close();
	fileWriter.close();
}

/*public static void main(String aas[]) throws Exception
{
	Dynmic_HTML ht=new Dynmic_HTML();
	ht.createHTML();
	ht.appendHTMLHeader();
	ht.appendHTMLRows("checkLogin","homepage","pass","c://sas.png");
	ht.appendHTMLRows("checklist","homepage","fail","c://sas12.png");
	ht.appendHTMLRows("checkdropdown","homepage","Pass","c://sas12.png");
	ht.appendHTMLRows("checkdelete","homepage","fail","c://sas12.png");

	ht.FLUSHBUFFER();
} */

}


