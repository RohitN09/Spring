import java.io.FileReader;
import java.util.Scanner;

public class FileReaderr {	
	public static void main(String[] args) {
		MyBean myBean = MyBean.getInstance();
		try(Scanner sc = new Scanner(new FileReader("src/data.txt"))){
			myBean.setFirstName(sc.nextLine());
			myBean.setLastName(sc.nextLine());
			System.out.println(myBean);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
