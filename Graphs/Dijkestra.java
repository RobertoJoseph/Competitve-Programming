import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkestra {
	static final int Inf = (int) (1e9);
	static ArrayList<Edge> adjList[];
	static int V;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int node, cost;

		Edge(int a, int b) {
			node = a;
			cost = b;
		}

		public int compareTo(Edge e) {
			return cost - e.cost;
		}
	}

	public static int dijkstra(int startingPoint, int endingPoint) {
		int[] dist = new int[V];
		Arrays.fill(dist, Inf);

		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[startingPoint] = 0;
		pq.add(new Edge(startingPoint, 0));
		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.node == endingPoint) {
				return dist[endingPoint];
			}
//			if (cur.cost > dist[cur.node]) {
//				continue;
//			}
			for (Edge nxt : adjList[cur.node]) {
				if (cur.cost + nxt.cost < dist[nxt.node]) {
					dist[nxt.node] = cur.cost + nxt.cost;
					parent[nxt.node] = cur.node;
					pq.add(new Edge(nxt.node, dist[nxt.node]));

				}

			}
		}
		return -1;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int startingPoint = sc.nextInt() - 1;
			int endingPoint = sc.nextInt() - 1;
			adjList = new ArrayList[n];
			V = n;
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<>();
			}
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				int weight = sc.nextInt();
				adjList[u].add(new Edge(v, weight));
				adjList[v].add(new Edge(u, weight));

			}
			parent = new int[V];
			int cur = parent[endingPoint];
			while (cur != 0) {
				System.out.println(cur);
				cur = parent[cur];

			}
//			int val = dijkstra(startingPoint, endingPoint);
//			if (val == -1)
//				System.out.println("NONE");
//			else
//				System.out.println(val);

		}

	}

}
