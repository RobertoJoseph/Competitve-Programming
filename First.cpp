#include <iostream>
using namespace std;
#include "stdc++.h"
const int N = 100 + 5;
int n, m;
vector<int> adjList[N];
bool vis[N];

void dfs(int node) {
	vis[node] = true;
	for (auto x : adjList[node]) {
		if (!vis[x]) {
			dfs(x);
		}
	}
}

void bfs(int node) {
	queue<int> queue;
	vis[node] = true;
	while (!queue.empty()) {
		node = queue.front();
		queue.pop();
		for (auto x : adjList[node]) {
			if (!vis[x]) {
				vis[x] = true;
				queue.push(x);

			}
		}
	}
}
void lower(string &x) {
	for (int i = 0; i < x.length(); i++) {
		x[i] = tolower(x[i]);
	}

}

int main() {
	int n;
	cin >> n;
	map<string, int> pop;
	pop["polycarp"]=1;
	int ans = -1;
	while (n-- > 0) {
		string a, b, c;
		cin >> a >> b >> c;
		lower(a);
		lower(c);
		pop[a] = pop[c] + 1;
		ans = max(ans, pop[a]);

	}
	cout << ans << endl;

	return 0;
}
