
import java.util.*;

public class Bellman {
	static final int inf = (int) (1e9);
	static ArrayList<Edge> adjList;
	static int V;
	static int[] dist;

	static class Edge implements Comparable<Edge> {
		int a, b, c;

		Edge(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		public int compareTo(Edge e) {
			return c - e.c;
		}

	}

	static boolean bellmanFord(int S, int tar) {

		Arrays.fill(dist, inf);
		dist[S] = 0;
		boolean hasCycle = false;
		boolean isUpdated = false;
		for (int i = 0; i < V; i++) {
			isUpdated = false;
			for (Edge g : adjList) {
				if (dist[g.b] > dist[g.a] + g.c) {
					dist[g.b] = dist[g.a] + g.c;
					isUpdated = true;
				}

			}
			if (!isUpdated) {
				break;
			} else if (isUpdated && i == V - 1) {
				hasCycle = true;
				break;

			}

		}
		if (hasCycle)
			return true;
		else
			return false;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		V = n;
		adjList = new ArrayList<Edge>();
		dist = new int[V];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int weight = sc.nextInt();
			adjList.add(new Edge(a, b, weight));
		}
		int src, tar;
		src = sc.nextInt();
		tar = sc.nextInt();
		boolean val = bellmanFord(--src, --tar);
		if (val) {
			System.out.println("Has negative cycle");
		} else
			System.out.println("NO cycle");

	}

}
