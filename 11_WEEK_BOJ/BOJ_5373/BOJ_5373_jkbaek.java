import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5373_jkbaek {
	static int [][][][]cube;
	static int dummy[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		for(int tt=1;tt<=t;tt++) {
		int n=sc.nextInt();
		cube=new int[3][3][3][6];
		dummy=new int[3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[i][j][0][0]=0;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[i][j][2][1]=1;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[2][i][j][2]=2;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[0][i][j][3]=3;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[i][0][j][4]=4;
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				cube[i][2][j][5]=5;
			}
		}
		
		for(int i=0;i<n;i++) {
			String x=sc.next();
			if(x.equals("U+")) {
				UP();
			}
			if(x.equals("U-")) {
				UM();
			}
			if(x.equals("D+")) {
				DP();
			}
			if(x.equals("D-")) {
				DM();
			}
			if(x.equals("F+")) {
				FP();
			}
			if(x.equals("F-")) {
				FM();
			}
			if(x.equals("B+")) {
				BP();
			}
			if(x.equals("B-")) {
				BM();
			}
			if(x.equals("L+")) {
				LP();
			}
			if(x.equals("L-")) {
				LM();
			}
			if(x.equals("R+")) {
				RP();
			}
			if(x.equals("R-")) {
				RM();
			}
//			System.out.println(x);
//			test();
//			System.out.println();
		}
		ans();

		
		
		}
	}
	public static void ans() {
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[i][j][0][0]==0) {
					System.out.print("w");
				}
				if(cube[i][j][0][0]==1) {
					System.out.print("y");
				}
				if(cube[i][j][0][0]==2) {
					System.out.print("r");
				}
				if(cube[i][j][0][0]==3) {
					System.out.print("o");
				}
				if(cube[i][j][0][0]==4) {
					System.out.print("g");
				}
				if(cube[i][j][0][0]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
	}
	public static void test() {
		System.out.println("상");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[i][j][0][0]==0) {
					System.out.print("w");
				}
				if(cube[i][j][0][0]==1) {
					System.out.print("y");
				}
				if(cube[i][j][0][0]==2) {
					System.out.print("r");
				}
				if(cube[i][j][0][0]==3) {
					System.out.print("o");
				}
				if(cube[i][j][0][0]==4) {
					System.out.print("g");
				}
				if(cube[i][j][0][0]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		System.out.println("하");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[i][j][2][1]==0) {
					System.out.print("w");
				}
				if(cube[i][j][2][1]==1) {
					System.out.print("y");
				}
				if(cube[i][j][2][1]==2) {
					System.out.print("r");
				}
				if(cube[i][j][2][1]==3) {
					System.out.print("o");
				}
				if(cube[i][j][2][1]==4) {
					System.out.print("g");
				}
				if(cube[i][j][2][1]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		System.out.println("전");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[2][j][i][2]==0) {
					System.out.print("w");
				}
				if(cube[2][j][i][2]==1) {
					System.out.print("y");
				}
				if(cube[2][j][i][2]==2) {
					System.out.print("r");
				}
				if(cube[2][j][i][2]==3) {
					System.out.print("o");
				}
				if(cube[2][j][i][2]==4) {
					System.out.print("g");
				}
				if(cube[2][j][i][2]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		System.out.println("후");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[0][j][i][3]==0) {
					System.out.print("w");
				}
				if(cube[0][j][i][3]==1) {
					System.out.print("y");
				}
				if(cube[0][j][i][3]==2) {
					System.out.print("r");
				}
				if(cube[0][j][i][3]==3) {
					System.out.print("o");
				}
				if(cube[0][j][i][3]==4) {
					System.out.print("g");
				}
				if(cube[0][j][i][3]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		System.out.println("좌");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[2-j][0][i][4]==0) {
					System.out.print("w");
				}
				if(cube[2-j][0][i][4]==1) {
					System.out.print("y");
				}
				if(cube[2-j][0][i][4]==2) {
					System.out.print("r");
				}
				if(cube[2-j][0][i][4]==3) {
					System.out.print("o");
				}
				if(cube[2-j][0][i][4]==4) {
					System.out.print("g");
				}
				if(cube[2-j][0][i][4]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		System.out.println("우");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if(cube[2-j][2][i][5]==0) {
					System.out.print("w");
				}
				if(cube[2-j][2][i][5]==1) {
					System.out.print("y");
				}
				if(cube[2-j][2][i][5]==2) {
					System.out.print("r");
				}
				if(cube[2-j][2][i][5]==3) {
					System.out.print("o");
				}
				if(cube[2-j][2][i][5]==4) {
					System.out.print("g");
				}
				if(cube[2-j][2][i][5]==5) {
					System.out.print("b");
				}
			}
			System.out.println();
		}
		
	}
	public static void UP() {
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][2];
		}
		//전=우
		for(int i=0;i<3;i++) {
			cube[2][i][0][2]=cube[2-i][2][0][5];
		}
		//우=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][0][5]=cube[0][2-i][0][3];
		}
		//후=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][0][3]=cube[i][0][0][4];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[i][0][0][4]=dummy[i];
		}
		
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][0];
		}
		//전=우
		for(int i=0;i<3;i++) {
			cube[2][i][0][0]=cube[2-i][2][0][0];
		}
		//우=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][0][0]=cube[0][2-i][0][0];
		}
		//후=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][0][0]=cube[i][0][0][0];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[i][0][0][0]=dummy[i];
		}
	}
	public static void UM() {
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][2];
		}
		//전=좌
		for(int i=0;i<3;i++) {
			cube[2][i][0][2]=cube[i][0][0][4];
		}
		//좌=후
		for(int i=0;i<3;i++) {
			cube[i][0][0][4]=cube[0][2-i][0][3];
		}
		//후=우
		for(int i=0;i<3;i++) {
			cube[0][2-i][0][3]=cube[2-i][2][0][5];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[2-i][2][0][5]=dummy[i];
		}
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][2-i][0][0];
		}
		//전=좌
		for(int i=0;i<3;i++) {
			cube[2][2-i][0][0]=cube[2-i][0][0][0];
		}
		//좌=후
		for(int i=0;i<3;i++) {
			cube[2-i][0][0][0]=cube[0][i][0][0];
		}
		//후=우
		for(int i=0;i<3;i++) {
			cube[0][i][0][0]=cube[i][2][0][0];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[i][2][0][0]=dummy[i];
		}
		
	}
	public static void DP() {
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][2][2];
		}
		//전=좌
		for(int i=0;i<3;i++) {
			cube[2][i][2][2]=cube[i][0][2][4];
		}
		//좌=후
		for(int i=0;i<3;i++) {
			cube[i][0][2][4]=cube[0][2-i][2][3];
		}
		//후=우
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][3]=cube[2-i][2][2][5];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][5]=dummy[i];
		}
		
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][2-i][2][1];
		}
		//전=좌
		for(int i=0;i<3;i++) {
			cube[2][2-i][2][1]=cube[2-i][0][2][1];
		}
		//좌=후
		for(int i=0;i<3;i++) {
			cube[2-i][0][2][1]=cube[0][i][2][1];
		}
		//후=우
		for(int i=0;i<3;i++) {
			cube[0][i][2][1]=cube[i][2][2][1];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[i][2][2][1]=dummy[i];
		}
	}
	public static void DM() {
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][2][2];
		}
		//전=우
		for(int i=0;i<3;i++) {
			cube[2][i][2][2]=cube[2-i][2][2][5];
		}
		//우=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][5]=cube[0][2-i][2][3];
		}
		//후=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][3]=cube[i][0][2][4];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[i][0][2][4]=dummy[i];
		}
		
		//더미=전
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][2][1];
		}
		//전=우
		for(int i=0;i<3;i++) {
			cube[2][i][2][1]=cube[2-i][2][2][1];
		}
		//우=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][1]=cube[0][2-i][2][1];
		}
		//후=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][1]=cube[i][0][2][1];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[i][0][2][1]=dummy[i];
		}
	}
	
	public static void FP() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][0];
		}
		//상=좌
		for(int i=0;i<3;i++) {
			cube[2][i][0][0]=cube[2][0][2-i][4];
		}
		//좌=하
		for(int i=0;i<3;i++) {
			cube[2][0][2-i][4]=cube[2][2-i][2][1];
		}
		//하=우
		for(int i=0;i<3;i++) {
			cube[2][2-i][2][1]=cube[2][2][i][5];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[2][2][i][5]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][2-i][0][2];
		}
		//상=좌
		for(int i=0;i<3;i++) {
			cube[2][2-i][0][2]=cube[2][0][i][2];
		}
		//좌=하
		for(int i=0;i<3;i++) {
			cube[2][0][i][2]=cube[2][i][2][2];
		}
		//하=우
		for(int i=0;i<3;i++) {
			cube[2][i][2][2]=cube[2][2][2-i][2];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[2][2][2-i][2]=dummy[i];
		}
	}
	public static void FM() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][0];
		}
		//상=우
		for(int i=0;i<3;i++) {
			cube[2][i][0][0]=cube[2][2][i][5];
		}
		//우=하
		for(int i=0;i<3;i++) {
			cube[2][2][i][5]=cube[2][2-i][2][1];
		}
		//하=좌
		for(int i=0;i<3;i++) {
			cube[2][2-i][2][1]=cube[2][0][2-i][4];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[2][0][2-i][4]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2][i][0][2];
		}
		//상=우
		for(int i=0;i<3;i++) {
			cube[2][i][0][2]=cube[2][2][i][2];
		}
		//우=하
		for(int i=0;i<3;i++) {
			cube[2][2][i][2]=cube[2][2-i][2][2];
		}
		//하=좌
		for(int i=0;i<3;i++) {
			cube[2][2-i][2][2]=cube[2][0][2-i][2];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[2][0][2-i][2]=dummy[i];
		}
	}
	public static void BP() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[0][i][0][0];
		}
		//상=우
		for(int i=0;i<3;i++) {
			cube[0][i][0][0]=cube[0][2][i][5];
		}
		//우=하
		for(int i=0;i<3;i++) {
			cube[0][2][i][5]=cube[0][2-i][2][1];
		}
		//하=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][1]=cube[0][0][2-i][4];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][4]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[0][i][0][3];
		}
		//상=우
		for(int i=0;i<3;i++) {
			cube[0][i][0][3]=cube[0][2][i][3];
		}
		//우=하
		for(int i=0;i<3;i++) {
			cube[0][2][i][3]=cube[0][2-i][2][3];
		}
		//하=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][3]=cube[0][0][2-i][3];
		}
		//좌=더미
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][3]=dummy[i];
		}
	}
	public static void BM() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[0][i][0][0];
		}
		//상=좌
		for(int i=0;i<3;i++) {
			cube[0][i][0][0]=cube[0][0][2-i][4];
		}
		//좌=하
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][4]=cube[0][2-i][2][1];
		}
		//하=우
		for(int i=0;i<3;i++) {
			cube[0][2-i][2][1]=cube[0][2][i][5];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[0][2][i][5]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[0][2-i][0][3];
		}
		//상=좌
		for(int i=0;i<3;i++) {
			cube[0][2-i][0][3]=cube[0][0][i][3];
		}
		//좌=하
		for(int i=0;i<3;i++) {
			cube[0][0][i][3]=cube[0][i][2][3];
		}
		//하=우
		for(int i=0;i<3;i++) {
			cube[0][i][2][3]=cube[0][2][2-i][3];
		}
		//우=더미
		for(int i=0;i<3;i++) {
			cube[0][2][2-i][3]=dummy[i];
		}
	}
	public static void LP() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][0][0][0];
		}
		//상=후
		for(int i=0;i<3;i++) {
			cube[i][0][0][0]=cube[0][0][2-i][3];
		}
		//후=하
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][3]=cube[2-i][0][2][1];
		}
		//하=전
		for(int i=0;i<3;i++) {
			cube[2-i][0][2][1]=cube[2][0][i][2];
		}
		//전=더미
		for(int i=0;i<3;i++) {
			cube[2][0][i][2]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2-i][0][0][4];
		}
		//상=후
		for(int i=0;i<3;i++) {
			cube[2-i][0][0][4]=cube[0][0][i][4];
		}
		//후=하
		for(int i=0;i<3;i++) {
			cube[0][0][i][4]=cube[i][0][2][4];
		}
		//하=전
		for(int i=0;i<3;i++) {
			cube[i][0][2][4]=cube[2][0][2-i][4];
		}
		//전=더미
		for(int i=0;i<3;i++) {
			cube[2][0][2-i][4]=dummy[i];
		}
	}
	public static void LM() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][0][0][0];
		}
		//상=전
		for(int i=0;i<3;i++) {
			cube[i][0][0][0]=cube[2][0][i][2];
		}
		//전=하
		for(int i=0;i<3;i++) {
			cube[2][0][i][2]=cube[2-i][0][2][1];
		}
		//하=후
		for(int i=0;i<3;i++) {
			cube[2-i][0][2][1]=cube[0][0][2-i][3];
		}
		//후=더미
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][3]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][0][0][4];
		}
		//상=전
		for(int i=0;i<3;i++) {
			cube[i][0][0][4]=cube[2][0][i][4];
		}
		//전=하
		for(int i=0;i<3;i++) {
			cube[2][0][i][4]=cube[2-i][0][2][4];
		}
		//하=후
		for(int i=0;i<3;i++) {
			cube[2-i][0][2][4]=cube[0][0][2-i][4];
		}
		//후=더미
		for(int i=0;i<3;i++) {
			cube[0][0][2-i][4]=dummy[i];
		}
	}
	public static void RP() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][2][0][0];
		}
		//상=전
		for(int i=0;i<3;i++) {
			cube[i][2][0][0]=cube[2][2][i][2];
		}
		//전=하
		for(int i=0;i<3;i++) {
			cube[2][2][i][2]=cube[2-i][2][2][1];
		}
		//하=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][1]=cube[0][2][2-i][3];
		}
		//후=더미
		for(int i=0;i<3;i++) {
			cube[0][2][2-i][3]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][2][0][5];
		}
		//상=전
		for(int i=0;i<3;i++) {
			cube[i][2][0][5]=cube[2][2][i][5];
		}
		//전=하
		for(int i=0;i<3;i++) {
			cube[2][2][i][5]=cube[2-i][2][2][5];
		}
		//하=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][5]=cube[0][2][2-i][5];
		}
		//후=더미
		for(int i=0;i<3;i++) {
			cube[0][2][2-i][5]=dummy[i];
		}
	}
	public static void RM() {
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[i][2][0][0];
		}
		//상=후
		for(int i=0;i<3;i++) {
			cube[i][2][0][0]=cube[0][2][2-i][3];
		}
		//후=하
		for(int i=0;i<3;i++) {
			cube[0][2][2-i][3]=cube[2-i][2][2][1];
		}
		//하=전
		for(int i=0;i<3;i++) {
			cube[2-i][2][2][1]=cube[2][2][i][2];
		}
		//전=더미
		for(int i=0;i<3;i++) {
			cube[2][2][i][2]=dummy[i];
		}
		
		//더미=상
		for(int i=0;i<3;i++) {
			dummy[i]=cube[2-i][2][0][5];
		}
		//상=후
		for(int i=0;i<3;i++) {
			cube[2-i][2][0][5]=cube[0][2][i][5];
		}
		//후=하
		for(int i=0;i<3;i++) {
			cube[0][2][i][5]=cube[i][2][2][5];
		}
		//하=전
		for(int i=0;i<3;i++) {
			cube[i][2][2][5]=cube[2][2][2-i][5];
		}
		//전=더미
		for(int i=0;i<3;i++) {
			cube[2][2][2-i][5]=dummy[i];
		}
	}
}
