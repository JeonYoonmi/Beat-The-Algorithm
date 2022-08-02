import java.util.Scanner;

public class Main {

	public static int[][] arr;

	public static int cnt1 = 0;
	public static int cnt2 = 0;
	public static int cnt3 = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int size = Integer.parseInt(scan.nextLine());

		arr = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		count(0, 0, size);

		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}

	public static void count(int col, int row, int size) {
		if (checkNumber(col, row, size)) {
			if (arr[row][col] == -1)
				cnt1++;
			else if (arr[row][col] == 0)
				cnt2++;
			else
				cnt3++;

			return;
		}

		int nsize = size / 3;

		count(col, row, nsize);
		count(col + nsize, row, nsize);
		count(col + nsize * 2, row, nsize);

		count(col, row + nsize, nsize);
		count(col + nsize, row + nsize, nsize);
		count(col + nsize * 2, row + nsize, nsize);

		count(col, row + nsize * 2, nsize);
		count(col + nsize, row + nsize * 2, nsize);
		count(col + nsize * 2, row + nsize * 2, nsize);
	}

	public static boolean checkNumber(int col, int row, int size) {
		int num = arr[row][col];
		
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (num != arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}
