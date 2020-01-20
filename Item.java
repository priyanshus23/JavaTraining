import java.util.Scanner;	
/* I have approached this problem with a different angle, have used setter to initialize values that are not yet defined by the user
 * getter is then used to input the values by the user then the object of the sub classes can help in get the values of the super class */
abstract class Item{
	private long uin;
	private String title;
	private int noOfCopies;
	protected String genre;
	Scanner sc =new Scanner(System.in);
	Item(){
		setContent();		
	}
	public void setContent(){
		
		uin=0;
		title="UnNamed";
		noOfCopies=0;
		genre="not Defines";
	}
	public void getUin() {
		System.out.println("Please Enter the Unique ID no.");
		uin=sc.nextLong();
	}
	public void getTitle() {
		System.out.println("Please enterthe title of the content");
		title=sc.next();
	}
	public void getNoOfCopies() {
		
		System.out.println("Enter the no of copies available");
		noOfCopies=sc.nextInt();
	}
	void getGenre() {
		System.out.println("Please enter the genre of the content");
		genre=sc.next();
	}
	public int checkin() {
		System.out.println("the item is checked in");
		return noOfCopies+1;	}   //Will show the no of copies available
	
	
	public int checkOut() {
		System.out.println("The item is checked out");
		return noOfCopies-1;		// This will show the no off copies remaineing after the checkout
		
	}
	
	public void addItem() {
		getUin();
		getTitle();
		getNoOfCopies();
		getGenre();
	}
}
	

abstract class WrittenItem extends Item{
	
	//will enter the commeon operation functions
	//such as
	// Bio of author
	// No of books
	// no of pages etc
	Item written;  //used as an example
	private String Write_type;
	WrittenItem(){
		written.addItem();		
	}
	void getType_written() {
		System.out.println("Please enter the written type");// pen printed etc
		Write_type=sc.next();
	}
		
	
}

class book extends WrittenItem{

	WrittenItem bookobj;
	book(){
		bookobj.getType_written();
	}
}
class JournalPaper extends WrittenItem{
	WrittenItem JPobj;
	JournalPaper(){
		JPobj.getType_written();
	}
}
abstract class MediaItem extends Item{
	Item media;
}
class Video extends MediaItem{
	private String director;
	private String genre_video;
	private int year;
	void getVideo() {
		System.out.println("Please enter the director type, genre_video,year of release");
		director=sc.next();
		genre_video=sc.next();
		year=sc.nextInt();
	}
	void getGenre(){		//overriding the Item's getGenre() function
		media.genre=genre_video;
	}
}
class CD extends MediaItem{
	private String artist;
	private String genre_Cd;		
	void getCD() {
		System.out.println("Please enter the artist, genre_CD");
		artist=sc.next();
		genre_Cd=sc.next();
		
		
	}
	void getGenre(){	
		//overriding the Item's getGenre() function
		media.addItem();
		getCD();
		media.genre=genre_Cd;
	}
	CD(){
		getGenre();
	}
}

