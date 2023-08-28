package javatest;

import java.util.*;


public class java13 {

	public static void main(String[] args) {
		search d = new search();
		//d.list();		//상속받은 메소드를 실행.
		d.datasearch();
	}

}

class datalist{	//DB 영역
	static String members[][] = null;	//필드에 원시배열 선언
	String userlist[] = null;
	public void list() {
		this.userlist =new String[] {"홍길동","이순신","유관순"};
		
		this.members = new String[][]{		// this를 이용해서 실행
				{"80","78","92","40"},
				{"40","80","80","100"},
				{"55","40","50","90"}			
		};
	}
}
 
class search extends datalist{
	Scanner sc = null;
	@Override
	public void list() {
		super.list();	// super은 상속 받을 때 해당 메소드를 실행 후 상속 받음
		//System.out.println(Arrays.toString(userlist));
		//System.out.println(this.members[0][1]);
		//System.out.println(Arrays.deepToString(members));	// deepToString : 2차 배열 출력하는방법.
	}
	
	public void datasearch() {
		this.list();
		this.sc = new Scanner(System.in);
		//System.out.println(Arrays.deepToString(this.members));
		System.out.println("학생명을 입력해 주세요?");
		String name = this.sc.nextLine().intern();
		int node = 0;
		
		for(String a : this.userlist) {
			if(a == name) {
				node = node;
				break;
			}
			else {
				node++;				
			}
		}
		//System.out.println(node);
		System.out.println("검색할 과목명을 입력하세요 (국어,수학,과학,역사)?:");
		String subject = this.sc.nextLine();
		int snode = 0; 	//과목에 대한 노드번호
		switch(subject) {
		/*
		case "1","2" -> System.out.println("ok");
		*/
		case "국어":
		snode = 0;
		
		break;
		
		case "수학":
		snode = 1;
		break;
		
		case "영어":
		snode = 2;
		break;
		
		case "역사":
		snode = 3;
		break;
			
		default:	//case외 사용되는 명령어
		System.out.println("해당 과목은 존재하지 않는 과목명입니다.");
		break;
	}
		System.out.println(name + " 학생 " + subject + " 과목의 점수는 " +this.members[node][snode] +"입니다.");
	}
	
}
/*
 * override 를 활용함
 * 응용문제 1
 * "학생명을 입력해 주세요?"
 * "검색할 과목명을 입력하세요 (국어,수학,과학,역사)?:"
 * 데이터는 데이터 별도의 Class를 이용합니다. 해당 class 안에 해당 배열 데이터가 
 * 있으며, 해당 데이터를 상속받아서 다음과 같이 결과가 돌출 되도록 프로세스를 작성 하시오.
 * 
 * [데이터]	-	override
 * {"홍길동","이순신","유관순"},
 * {"80","78","92","40"},
 * {"40","80","80","100"},
 * {"55","40","50","90"}
 * 
 * 결과	- overloading
 * 홍길동
 * 과학 88
 * */
