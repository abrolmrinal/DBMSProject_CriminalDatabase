
public class Arrest {
	public String CriminalID;
    public String Criminal_Name;
    public String Height;
    public String Weight;
    public String Age;
    public String House_Number;
    public String Street;
    public String City;
    public String Time;
    public String Date;
    
    Arrest(int cid,String name,float h,int w,int age,String house,String stre,String city ,String tim,String date)
    {
    	CriminalID=new String(cid+"");
        Criminal_Name=new String(name);
        Height=new String(h+"");
        Weight=new String(w+"");
        Age=new String(age+"");
        House_Number=new String(house);
        Street=new String(stre);
        City=new String(city);
        Time=new String(tim);
        Date=new String(date);
    }
}
