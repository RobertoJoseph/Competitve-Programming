import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EditDistance {
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

	public  static int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
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

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Sc sc = new Sc(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		while (t-- > 0) {
			String a = sc.next();
			String b = sc.next();
			char[] aa = a.toCharArray();
			char[] bb = b.toCharArray();
			int val = dynamicEditDistance(aa, bb);
			pw.println(val);
		}
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
