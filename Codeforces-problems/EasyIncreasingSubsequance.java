import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	static final long inf = (long) (1e18);
	static int V;
	static int[] dist;
	static long[][] adjMatrix;

	static void floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

		// to find the parent on the shortest path
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Sc sc = new Sc(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] array = new int[n + 2];
		
		for (int i = 1; i<=n; i++) {
			array[i] = sc.nextInt();

		}
		array[0] = 0;
		int[][] dp = new int[n + 2][n + 2];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (array[i] > array[j]) {
					dp[i + 1][i] = Math.max(dp[i + 1][i], dp[i][j] + 1);

				}
				dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);

			}
		}
		int max =1;
		//When pushing so we need dp[n+1] not dp[n]
		for(int i =0; i<=n; i++) {
			max=Math.max(max, dp[n+1][i]);
		}
		pw.println(max);

		pw.flush();
		pw.close();

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
