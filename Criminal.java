/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ishbir Walia
 */
public class Criminal {
    public String CriminalID;
    public String Criminal_Name;
    public String Height;
    public String Weight;
    public String Age;
    public String House_Number;
    public String Street;
    public String City;
    
    
    Criminal(int cid,String name,float h,int w,int age,String house,String stre,String city)
    {
        CriminalID=new String(cid+"");
        Criminal_Name=new String(name);
        Height=new String(h+"");
        Weight=new String(w+"");
        Age=new String(age+"");
        House_Number=new String(house);
        Street=new String(stre);
        City=new String(city);
        
    }
}