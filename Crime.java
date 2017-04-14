
public class Crime {
	public String CrimeID;
	public String Crime_Time;
	public String Crime_Date;
	public String Type;
	public String House;
	public String Street;
	public String City;
	
	
	Crime(int cid,String tim,String date,String type,String h,String stre,String city)
	{
		CrimeID=new String(cid+"");
		Crime_Time=tim;
		Crime_Date=date;
		Type=type;
		House=h;
		Street=stre;
		City=city;
	}
}
