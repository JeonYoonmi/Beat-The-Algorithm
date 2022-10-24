import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
	* 문제
		트리의 지름은 트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 것을 말한다.
		트리의 지름을 구하시오.
		
	* 입력
		1번 째 줄에서 트리의 노드 개수 V(2 <= V <= 100,000), 
		2번 째 줄부터 V개의 줄에 걸쳐 에지의 정보가 주어진다.
		먼저 노드의 번호가 주어지고, 
		그 다음으로 연결된 에지의 정보를 의미하는 정수가 2개씩(연결된 노드 번호, 거리) 주어진다.
		거리는 10,000 이하의 자연수다.
		
		예를 들어 2번째 줄에 31243-1이 주어질 때 노드 3은 노드 1과 거리가 2인 에지로 연결돼있고, 
		노드 4는 거리가 3인 에지로 연결돼 있다는 뜻이다.
		-1은 더이상 노드가 없으므로 종료한다는 의미다.
		
	* 출력
		트리의 지름을 출력한다.
*/

public class Main {
	// 방문 기록 저장 배열 선언
	static boolean visited[];
	// 거리 저장 배열 선언
	static int[] distance;
	// 그래프 데이터 저장 인접 리스트 생성
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		// 입력을 받기 위한 Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		
		// 노드 개수 입력
		int N = sc.nextInt();
		
		// 인접 리스트 => 노드의 번호를 입력하기 위해서(1번 부터) N이 아닌 N+1의 사이즈로 생성
		A = new ArrayList[N + 1];
		// A[i] 안에  Edge타입의 리스트 생성 => A[i]에 연결된 노드가 여러개일 수 있기 때문
		for(int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		
		// A의 인접 리스트에 그래프 데이터 저장하기
		for(int i = 0; i < N; i++) {
			// 노드 번호 입력
			int S = sc.nextInt();
			
			// E의 값에 -1이 입력될 때까지 반복
			while(true) {
				// 노드 S와 연결된 노드 번호 입력
				int E = sc.nextInt();
				
				// E의 값이 -1이면 반복문 중지
				if(E == -1) break;
				
				// 연결된 노드의 가중치 입력
				int V = sc.nextInt();
				
				// A[S]에 E, V의 값이 담긴 Edge객체로 초기화
				A[S].add(new Edge(E, V));
			}
		}
		
		// distance에 int형 배열 생성
		distance = new int[N + 1];
		// visited에 boolean형 배열 생성
		visited = new boolean[N + 1];
		
		// BFS(임의의 시작점) 실행
		BFS(1);
		
		// 거리가 가장 긴 노드 찾기
		// 최대 노드 번호를 저장할 변수 초기화
		int Max = 1;
		// 노드번호를 1번으로 초기화 했으므로 2~N번까지의 노드의 거리를 비교하면 됨
		for(int i = 2; i <= N; i++) {
			// Max번 노드에 해당하는 거리보다 i번 노드에 해당하는 거리가 더 크면
			if(distance[Max] < distance[i]) {
				// Max 변수에 i번 값으로 변경
				Max = i;
			}
			
			// distance와 visited 배열을 생성
			distance = new int[N + 1];
			visited = new boolean[N+1];
			// BFS(Max) 실행
			BFS(Max);
			
			// distance 배열의 값들을 정렬
			Arrays.sort(distance);
			
			// distance의 가장 마지막 인덱스의 값을 출력
			System.out.println(distance[N]);
		}
	}
	
	// BFS 메소드
	private static void BFS(int index) {
		// 큐 자료 구조 생성
		Queue<Integer> queue = new LinkedList<Integer>();
		// 큐 자료 구조에 시작노드 삽입하기
		queue.add(index);
		
		// visited 배열에 시작노드를 true로 설정 => 방문했다는 의미
		visited[index] = true;
		
		// queue 자료구조안에 값이 없을 때까지 반복
		while(!queue.isEmpty()) {
			// queu에서 노드 데이터 가지고 오기
			int now_node = queue.poll();
			
			// 가저온 노드번호에 해당하는 연결된 노드들을 하나씩 꺼내기
			for (Edge i : A[now_node]) {
				// 변수 e에 연결된 노드 번호의 값으로 초기화
				int e = i.e;
				// 변수 v를 연결된 노드 번호에 해당하는 가중치 값으로 초기화
				int v = i.value;
				
				// 현재 노드의 연결 노드 중 방문하지 않은 노드라면
				if(!visited[e]) {
					// visited 배열에 방문했다고 변경
					visited[e] = true;
					// 큐 데이터를 삽입
					queue.add(e);
					// 현재 노드의 거리 + 가중치로 방문하지 않은 노드 거리를 업데이트
					distance[e] = distance[now_node] + v;
				}
			}
		}
	}
}

class Edge{
	// 연결된(목적지) 노드 변수 생성
	int e;
	// 가중치 변수 생성
	int value;
	
	// 생성자
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
