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
    	sgobj.CreateExcel("D:\\Software\\Database_2020\\db shop database\\Shopping_mall\\", "bangalore_shoppingmall");
    	driver.navigate().to("https://www.google.com/search?biw=1536&bih=748&tbm=lcl&ei=O9hZX5POHZa89QPAv6LoCw&q=general+physician+in+indore&oq=general+physician+in+indore&gs_l=psy-ab.3..0l2j0i22i30k1l6.909376.910111.0.910312.6.6.0.0.0.0.219.219.2-1.1.0....0...1c.1.64.psy-ab..5.1.218....0.x_ZN1O-qW0c#rlfi=hd:;si:;mv:[[22.7695629,75.9310725],[22.6390605,75.8225369]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:2");
   	    Thread.sleep(5000);
   	    String url = "https://www.google.com/search?biw=1522&bih=734&tbm=lcl&ei=tbirX_6EDvTXz7sPhfKZwAI&q=shopping+mall+in+bangalore&oq=shopping+mall+in+bangalore&gs_l=psy-ab.3..0i457i10k1j0i10k1j0i22i30k1l8.877101.880384.0.880885.15.15.0.0.0.0.507.2501.0j3j6j5-1.10.0....0...1c.1.64.psy-ab..7.8.2055...0j0i457i67k1.0.lC_mtUguR3c#rlfi=hd:;si:;mv:[[13.055294799999999,77.74774959999999],[12.865637699999999,77.54065109999999]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u2!2m2!2m1!1e1!2m1!1e2!2m1!1e3!3sIAE,lf:1,lf_ui:10";
   	     
   	    String city = "bangalore";
   	    String category = "shopping_mall";
   	    sgobj.fetchdata(url, city, category);
    }
}
