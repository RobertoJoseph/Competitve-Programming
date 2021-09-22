import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Floyd {
	static final long inf = (long) (1e18);
	static int V;
	static int[] dist;
	static long[][] adjMatrix;



	static void floyd() {
		for (int k = 0; k < V; k++) {
			for (int u = 0; u < V; u++) {
				for (int v = 0; v < V; v++) {
					adjMatrix[u][v] = Math.min(adjMatrix[u][v], adjMatrix[u][k] + adjMatrix[k][v]);
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int q = sc.nextInt();
		V = n;
		adjMatrix = new long[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j)
					adjMatrix[i][j] = 0;
				else
					adjMatrix[i][j] = inf;
			}
		}
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			long c = sc.nextLong();
			adjMatrix[u][v] = Math.min(adjMatrix[u][v], c);
			adjMatrix[v][u] = Math.min(adjMatrix[v][u], c);
		}
		floyd();
		while (q-- > 0) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			if (adjMatrix[u][v] >= inf) {
				pw.println(-1);

			} else
				pw.println(adjMatrix[u][v]);
		}

		pw.flush();
		pw.close();

	}

	/**
	 *
	 * Fixed Window Find the max sum subarray of a fixed size K
	 *
	 * Example input: [4, 2, 1, 7, 8, 1, 2, 8, 1, 0]
	 *
	 */
	
	
}
