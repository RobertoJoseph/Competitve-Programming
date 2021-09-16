import java.util.*;

public class Git {
	static int N = (int) (10e5 + 1);
	static int[] parent = new int[N];
	static int cnt = 1;

	public static int findParent(int u) {
		if (parent[u] == u) {
			return u;

		}
		return parent[u] = findParent(parent[u]);

	}

	public static void join(int u, int v) {
		u = findParent(u);
		v = findParent(v);
		if (u == v)
			return;
		parent[u] = v;
	

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
		
			
		}

//		

	}

}
