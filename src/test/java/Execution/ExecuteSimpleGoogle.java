package Execution;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.AppDriver;
import Modules.Simpleonegoogle;

public class ExecuteSimpleGoogle extends AppDriver 
{
    @Test
    public void getData() throws IOException, InterruptedException
    {
    	Simpleonegoogle sgobj = new Simpleonegoogle();
    	sgobj.CreateExcel("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\Google\\", "ukschool");
    	driver.navigate().to("https://www.google.com/search?sz=0&tbm=lcl&ei=sabjXtn8FIX39QPLzIvQAQ&q=Schools%20in%20Haryana&oq=Schools+in+Haryana&gs_l=psy-ab.3...0.0.0.43069.0.0.0.0.0.0.0.0..0.0....0...1c..64.psy-ab..0.0.0....0.O5qAoCJK72c&tbs=lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!2m4!1e17!4m2!17m1!1e2!3sIAE,lf:1,lf_ui:2&rlst=f#rlfi=hd:;si:;mv:[[29.3367429,77.4264778],[28.1636219,76.8537856]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!2m4!1e17!4m2!17m1!1e2!3sIAE,lf:1,lf_ui:2");
   	    Thread.sleep(180000);
   	    String url = "https://www.google.com/search?biw=1536&bih=674&tbm=lcl&sxsrf=ALeKk014WwzOXatqsVAxC8WZQQaLTOAzIg%3A1592774402933&ei=As_vXsPCOJbUz7sPjdOAkAM&q=schools+in+uttarakhand&oq=schools+in+ut&gs_l=psy-ab.3.2.35i39k1j0l8j0i20i263k1.3960754.3961960.0.3965632.11.9.0.0.0.0.319.1246.0j3j2j1.6.0....0...1c.1.64.psy-ab..10.1.318....0.dBdplVBgZsY#rlfi=hd:;si:;mv:[[30.595825299999998,79.5875963],[28.3866875,77.1633939]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!1m4!1u16!2m2!16m1!1e1!1m4!1u16!2m2!16m1!1e2!2m1!1e2!2m1!1e16!2m1!1e3!3sIAE,lf:1,lf_ui:2";
   	    String city = "Uttrakhand";
   	    String category = "Schools";
   	    sgobj.fetchdata(url, city, category);
    }
}
