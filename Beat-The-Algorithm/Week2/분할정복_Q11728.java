import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		List<Integer> list = new ArrayList<Integer>();
		
		String[] sizes = br.readLine().split(" ");
		
		int n = Integer.parseInt(sizes[0]);
		int m = Integer.parseInt(sizes[1]);
		
		String[] arrA = br.readLine().split(" ");
		String[] arrB = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(arrA[i]));
		}
		for(int i=0; i<m; i++) {
			list.add(Integer.parseInt(arrB[i]));
		}
		
		Collections.sort(list);
		
		for (int num : list) {
			bw.write(num + " ");
		}
		
		bw.close();
		br.close();
	}
}
