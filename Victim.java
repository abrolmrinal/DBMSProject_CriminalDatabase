
public class Victim {
	public String VictimID;
	public String Name;
	public String Age;
	public String Sex;
	
	Victim(int vid,String name, int age,String sex)
	{
		VictimID=new String(vid+"");
		Name=name;
		Age=new String(age+"");
		Sex=sex;
	}
	
}
