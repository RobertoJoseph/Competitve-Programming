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

	static void floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

		// to find the parent on the shortest path
		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);

	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Sc sc = new Sc(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			if (i + a <= n && (i == 0 || dp[i] > 0)) {
				dp[i + a] = Math.max(dp[i + a], dp[i] + 1);
			}
			if (i + b <= n && (i == 0 || dp[i] > 0)) {
				dp[i + b] = Math.max(dp[i + b], dp[i] + 1);
			}
			if (i + c <= n && (i == 0 || dp[i] > 0)) {
				dp[i + c] = Math.max(dp[i + c], dp[i] + 1);
			}

		}
		pw.println(dp[n]);

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