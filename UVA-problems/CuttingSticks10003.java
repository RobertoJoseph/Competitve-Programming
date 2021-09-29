import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CutRibbon {
	static final long inf = (long) (1e18);
	static int V;
	static int[] dist;
	static long[][] adjMatrix;
	static int[][] memo;
	static int[] cuts;
	static int N;

	static void floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

		// to find the parent on the shortest path
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);

	}

	public static int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}

	static void bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}

			}
		}

	}

	public static int dynamicEditDistance(char[] str1, char[] str2) {
		int temp[][] = new int[str1.length + 1][str2.length + 1];

		for (int i = 0; i < temp[0].length; i++) {
			temp[0][i] = i;
		}

		for (int i = 0; i < temp.length; i++) {
			temp[i][0] = i;
		}

		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					temp[i][j] = temp[i - 1][j - 1];
				} else {
					temp[i][j] = 1 + min(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]);
				}
			}
		}

		return temp[str1.length][str2.length];

	}

	static void bubbleSorts(long[] arr) {
		ArrayList<Long> list = new ArrayList<Long>();
		int count = 0;
		int n = arr.length;
		long temp = (long) 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					count++;
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					list.add((long) j);
					list.add((long) (j + 1));
//					System.out.println((j) + " " + (j + 1) + " " + 1);
				}

			}
		}
//		System.out.println(list);
		System.out.println(count);
		for (int i = 0; i < list.size() - 1; i += 2) {
			System.out.println(list.get(i) + " " + list.get(i + 1) + " " + 1);
		}

	}

	static int solve(int idx, int jdx, int l, int r) {
		if (idx > jdx || l == r) {
			return 0;

		}
		if (memo[idx][jdx] != -1)
			return memo[idx][jdx];
		int ans = Integer.MAX_VALUE;
		for (int i = idx; i <= jdx; i++) {
			ans = Math.min(ans, solve(idx, i - 1, l, cuts[i]) + solve(i + 1, jdx, cuts[i], r) + r - l);

		}
		return memo[idx][jdx] = ans;

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Sc sc = new Sc(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		while (true) {
			int l = sc.nextInt();
			if (l == 0)
				break;
			N = sc.nextInt();
			cuts = sc.nextArr(N);
			memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(memo[i], -1);
			}
			System.out.println(("The minimum cutting is " + solve(0, N - 1, 0, l))+".");
		}System.out.println();

	}

	public static class Sc {
		StringTokenizer st;
		BufferedReader br;

		public Sc(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public Sc(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

		public int[] nextArr(int n) throws IOException {
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = nextInt();
			return arr;
		}
	}

	/**
	 *
	 * Fixed Window Find the max sum subarray of a fixed size K
	 *
	 * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
	 *
	 */

}
