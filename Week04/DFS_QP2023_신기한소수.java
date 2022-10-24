import java.util.Scanner;

/*
	* 문제
		수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 이용해 노는 것이다.
		요즘 수빈이가 가장 관심이 있어 하는 소수는 7331이다.
		7331은 신기하게도 733도 소수 733도 소수, 73도 소수, 7도 소수다.
		즉, 욈쪽부터 1자리, 2자리, 3자리, 4릿수 모두 소수다.
		수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
		수빈이는 N의 자리의 숫자중 어떤 수들이 신기한 소수인지 궁금해졌다.
		숫자 N이 주어졌을 때 N의 자리 숫자 중 신기한 소수를 모두 찾아보자.
	
	* 입력
		1번 째 줄에 N(1<= N <= 8)이 주어진다.
	
	* 출력
		N의 자리 숫자 중 신기한 소수를 오름차순 정렬해 1줄에 1개씩 출력한다.
*/

public class DFS_P2023 {
	// 입력 받을 자릿수를 저장할 변수를 선언
	static int N;
	
	public static void main(String[] args) {
		// 입력을 받기 위한 Scanner객체 생성
		Scanner in = new Scanner(System.in);
		
		// 원하는 자리ㅛ수를 입력
		N = in.nextInt();
		
		// 한자리 수 중 소수인 2, 3, 5, 7을 DFS메소드를 시행
		DFS(2,1);
		DFS(3,1);
		DFS(5,1);
		DFS(7,1);
	}
	
	// DFS 메소드
	static void DFS(int number, int jarisu) {
		
		// jarisu가 입력한 자릿수와 같으면
		if(jarisu == N) {
			
			// number가 소수인지의 여부를 확인해서 소수이면 출력
			if(isPrime(number)) {
				System.out.println(number);
			}
			
			// 소수가 아니면 메소드 종료
			return;
		}
		
		// 입력한 자릿수 N보다 jarisu가 작으면
		// 1~9 사이 중에 뒤에 붙을 수를 구하기 위한 반복문
		for(int i = 1; i < 10; i++) {
			
			// number * 10 + i가 소수이기 위해서는 i는 짝수이면 안된다.
			if(i % 2 == 0) {
				continue;
			}
			
			// number * 10 + i가 소수인지 확인해서 소수라면
			if(isPrime(number * 10 + i)) {
				
				// DFS메소드에 number * 10 + i와 지금 jarisu+1인 값을 넣어 메소드를 시행한다.
				DFS(number * 10 + i, jarisu + 1);
			}
		}
	}
	
	// 소수인지 확인하는 메소드
	static boolean isPrime(int num) {
		
		// 나누어서 나오는 몫은 2부터 체크하면 되고, 소수는 1로 나누어지기 떄문에 i는 2부터 num / 2까지 반복문을 돌려
		for(int i = 2; i < num / 2; i++)
			
			// num이 i로 나누었을 때 나머지가 0이면 소수가 아니므로
			if(num % i == 0)
				
				// false를 반환한다.
				return false;
			
		// 소수이면 true 반환
		return true;
	}
}
