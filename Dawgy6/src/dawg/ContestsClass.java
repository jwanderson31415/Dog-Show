package dawg;

import java.io.Serializable;
import java.util.ArrayList;

public class ContestsClass implements Serializable{
	
	private String name;
	private int score;
	private ActualDog dog;
	private int DogCount;
	private RecordsPanel rc;
	ArrayList<ActualDog> doglist = new ArrayList<ActualDog>();
	
	
	
	public ContestsClass(String name) {
		this.name = name;
		//this.score = Integer.parseInt(score);
		
	
	}

	public ArrayList<ActualDog> getAlist() {
		return doglist;

	}
	
	public Object[][] formatArray(ArrayList<ActualDog> list) {

		Object[][] data = new Object[list.size()][];
		int index = 0;

		for (ActualDog dog : list) {
			Object[] dogInfo = new Object[9];
			dogInfo[0] = dog.getName();
			dogInfo[1] = dog.getId();
			dogInfo[2] = dog.getGender();
			dogInfo[3] = dog.getOwner();
			dogInfo[4] = dog.getfScore();
			dogInfo[5] = dog.getgScore();
			dogInfo[6] = dog.getoScore();
			dogInfo[7] = dog.getsScore();
			// dogInfo[8] = dog.getImage();
			data[index++] = dogInfo;
		}

		return data;

	}

	public String getName() {
		return name;
	}
	
	//Update Grooming
	public void Grooming(String ID, int score)
	{
		for(int i = 0; i < DogCount; i++)
			if(doglist.get(i).getId().equals(ID)) {
				doglist.get(i).setgScore(score);
				System.out.println(doglist.get(i).getName() + "'s score is: " + doglist.get(i).getgScore());
			}
		dogs();
		
	}
	
	public void Socialization(String ID, int score)
	{
		for(int i = 0; i < DogCount; i++)
			if(doglist.get(i).getId().equals(ID)) {
				System.out.println(score);
				doglist.get(i).setsScore(score);
				System.out.println(doglist.get(i).getName() + "'s score is: " + doglist.get(i).getsScore());
			}
		dogs();
	}
	
	public void Obedience(String ID, int score)
	{
		for(int i = 0; i < DogCount; i++)
			if(doglist.get(i).getId().equals(ID)) {
				System.out.println(score + "!!!");
				doglist.get(i).setoScore(score);
				System.out.println(doglist.get(i).getName() + "'s score is: " + doglist.get(i).getoScore());
			}
		dogs();
	
	}
	
	public void Fetch(String ID, int score)
	{
		for(int i = 0; i < DogCount; i++)
			if(doglist.get(i).getId().equals(ID)) {
				doglist.get(i).setfScore(score);
				System.out.println(doglist.get(i).getName() + "'s score is: " + doglist.get(i).getfScore());
			}
		dogs();
		
	}
	
	public void dogs() {
		for(int i = 0; i < DogCount; i++) {
			String n = doglist.get(i).getName();
			int g = doglist.get(i).getgScore();
			int o = doglist.get(i).getoScore();
			int s = doglist.get(i).getsScore();
			int f = doglist.get(i).getfScore();
			System.out.println(n + "'s Scores: " + g + " " + o + " " + s + " " + f );
		}
		
	}
	

	public ArrayList<ActualDog> sendArray() {
		return doglist;
		
		
	}
	
	
	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}
	
	public int getDogCount() {
		return DogCount;
	}
	
	public ActualDog findDog(String name)
	{
		for(int i = 0; i < DogCount; i++) {
			if(doglist.get(i).getName().equals(name))
				return doglist.get(i);
		}

		return doglist.get(0);
	}
	
	public ArrayList<String> getDogNames(){
		ArrayList<String> names = new ArrayList<String>();
		names.add("Dog Name");
		for(int i = 0; i < DogCount; i++)
		{
			names.add(doglist.get(i).getName());
		}
		
		return names;
	}
	
	public void addDog(String name, String id, String owner, String gender, boolean groom,
			boolean obedience, boolean social, boolean fetch, DnDImagePanel dnd) {
		ActualDog x = new ActualDog(name, id, owner, gender, groom, obedience, social, fetch, dnd);
		doglist.add(x);
		DogCount++;
		for(int i = 0; i < DogCount; i++) {
			System.out.println(doglist.get(i).getName());
		}

	}
	
	public int getGroomScore(String name) {
		for(int i = 0; i < DogCount; i++) {
			if(doglist.get(i).getName().equals(name))
				return doglist.get(i).getgScore();
			
		}
		return 0;
	}


	public boolean isScored() {
		boolean check = true;
		for(int i = 0; i < DogCount; i++) {
			if(doglist.get(i).getgScore() == 0 || doglist.get(i).getfScore() == 0 || doglist.get(i).getoScore() == 0 || doglist.get(i).getsScore() == 0)
				check = false;
		}
		
		return check;
		
		
	}
	
	public String notScored() {
		String str = "";
		for(int i = 0; i < DogCount; i++) {
			if(doglist.get(i).getgScore() == 0 || doglist.get(i).getfScore() == 0 || doglist.get(i).getoScore() == 0 || doglist.get(i).getsScore() == 0)
				str += doglist.get(i).getName() + " ";
		}
		return str;
	}

}