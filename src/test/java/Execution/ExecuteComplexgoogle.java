package Execution;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.AppDriver;
import Modules.Googleda;

public class ExecuteComplexgoogle extends AppDriver 
{
  @Test
  public void Getdata() throws IOException, InterruptedException
  {
	  Googleda gdobj = new Googleda();
	  gdobj.CreateExcel("D:\\Software\\Database_2020\\db shop database\\Restaurant_mains\\google\\", "Restaurant");
	  driver.navigate().to("https://www.google.com/search?sz=0&tbm=lcl&ei=sabjXtn8FIX39QPLzIvQAQ&q=Schools%20in%20Haryana&oq=Schools+in+Haryana&gs_l=psy-ab.3...0.0.0.43069.0.0.0.0.0.0.0.0..0.0....0...1c..64.psy-ab..0.0.0....0.O5qAoCJK72c&tbs=lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!2m4!1e17!4m2!17m1!1e2!3sIAE,lf:1,lf_ui:2&rlst=f#rlfi=hd:;si:;mv:[[29.3367429,77.4264778],[28.1636219,76.8537856]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!2m4!1e17!4m2!17m1!1e2!3sIAE,lf:1,lf_ui:2");
	  Thread.sleep(3000);
	  gdobj.fetchdata("D:\\Software\\Database_2020\\db shop database\\Restaurant_mains\\google\\Resta_Url.xlsx", 1);
  }
}
