#include"bits/stdc++.h"

#define FIO ios_base::sync_with_stdio(0);cin.tie(0);
using namespace std;
typedef long long ll;

const int N = 1e5 + 5, M = 1e3 + 5, MOD = 1e9 + 7, OO = 0x3f3f3f3f;
const ll LOO = 0x3f3f3f3f3f3f3f3f;
const long double EPS = 1e-8;
int mx = -1e9;
int mn = 1e9;

int n;
vector<int> arr;
vector<vector<int>> adj;
vector<bool> visited;


void dfs(int u) {
    visited[u] = 1;
    for (int v : adj[u]) {
        if (adj[u].size() >= 2) {

            if (visited[v])continue;
            dfs(v);
        }
    }
}

int main() {
    FIO
    int t;
    cin >> t;
    while (t-- > 0) {
        int n, k;
        visited = vector<bool>(n, 0);
        adj.resize(n);
        for (int i = 0; i < n; i++) {
            int a, b;
            cin >> a >> b;
            adj[--a].push_back(--b);
            adj[b].push_back(a);


        }
    }


    return 0;
}
