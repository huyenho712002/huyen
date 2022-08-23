
package Assignment2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

public static void main(String[] args) {

	
	Scanner sc = new Scanner(System.in);
	@SuppressWarnings("unused")


	int n = 0;

	boolean sw = true;


	while(sw) {
		try {
			int zz=0;
			System.out.println("1.Input candidate \n"+
					"2.Show list candidate \n"+
					"3.End \n");
			zz = sc.nextInt();
			switch(zz) {
				case 1:
					System.out.println(" Input Type of Candidate \n"+
							"0.Experience \n"+
							"1.Fresher \n"+
							"2.Intern \n");
					boolean dung=true;
					while (dung){
						try{
							n = sc.nextInt();
							dung = false;
						}
						catch (Exception e){
						}
					}
					addCandidate(n);
					break;
				case 2:
					showListCandidate();
					break;
				case 3:
					sw = false;
					break;

			};
		}catch(Exception ex) {


			System.out.println("Input again: ");

		}
	}


}

	public static void addCandidate(int zz){

		Certificate certificate = new Certificate();

		switch(zz) {
			case 0:
				Experience experience = new Experience();
				System.out.println("Experience"+ zz);
				experience.inputInfo();certificate.inputCertificate(experience.getCandidateID());
				certificate.showMe();	experience.showMe();
				Candidate.candidateList.add((Candidate)experience);
				Candidate.certificatelist.add(certificate);
				System.out.println(Candidate.certificatelist.size());
				break;
			case 1:
				Candidate fresher = new Fresher();//downcasting
				System.out.println("Fresher : "+ zz);fresher.inputInfo();
				fresher.showMe();
				certificate.inputCertificate(fresher.getCandidateID());
				certificate.showMe();
				certificate.showMe();
				Candidate.candidateList.add((Candidate)fresher);
				Candidate.certificatelist.add(certificate);
				break;
			case 2: System.out.println("Intern"+ zz);
				Intern intern = new Intern();
				intern.inputInfo();
				intern.showMe();
				certificate.inputCertificate(intern.getCandidateID());
				certificate.showMe();
				Candidate.candidateList.add((Candidate)intern);
				Candidate.certificatelist.add(certificate);
				break;

		};
	}
public static void showListCandidate(){
	System.out.println("Candidate Quantity : " + Candidate.count);
	for(Candidate candidate1: Candidate.candidateList){
		System.out.println("Candidate List");
		candidate1.showMe();
		System.out.println( "List FullName");
		String str =Candidate.candidateList.get(0).getFullName();
		StringBuffer stringbuffer = new StringBuffer(str);
		stringbuffer.append(",");
		System.out.println(stringbuffer);
	}
	for( Certificate cer : Candidate.certificatelist) {
		System.out.println("Certificate List");
		System.out.println();
		cer.showMe();
	}
}

}
