import java.util.*;

public class MST_Kruskal {
	static Edge[] edgeList;
	static int V;

	static long kruskal() // O(E log E)
	{
		long mst = 0;
		Arrays.sort(edgeList);
		UnionFind uf = new UnionFind(V);
		for (Edge e : edgeList)
			if (uf.findParent(e.u) != uf.findParent(e.v)) {
				mst += e.w;
				uf.joinSet(e.u, e.v);
			}
		return mst;
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int a, int b, int c) {
			u = a;
			v = b;
			w = c;
		}

		public int compareTo(Edge e) {
			return w - e.w;
		}
	}

	static class UnionFind {
		int[] p, sizeParent;

		public UnionFind(int N) {
			p = new int[N];
			sizeParent = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				sizeParent[i] = 1;
			}
		}

		public int findParent(int i) {
			if (p[i] == i)
				return i;
			else
				return p[i] = findParent(p[i]);
		}

		public Boolean isSameSet(int i, int j) {
			return findParent(i) == findParent(j);
		}

		public void joinSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			int x = findParent(i), y = findParent(j);
			// rank is used to keep the tree short
			p[y] = x;
			sizeParent[x] += sizeParent[y];

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		V = n;
		edgeList = new Edge[m];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int weight = sc.nextInt();
			edgeList[i] = new Edge(a, b, weight);
		}
		System.out.println(kruskal());

	}

//		

}
