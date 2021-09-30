#include"bits/stdc++.h"

using namespace std;
typedef long long ll;


const int N = 1e5 + 5;
int coins[] = {1, 5, 10, 25, 50};


string a, b;
int n, mn = 1e5 + 1, mx = 0;
int freq[N];
vector<vector<int>> mem;
string f, s;



int solve(int i, int j) {
    if (i > j)return 0;
    if (mem[i][j] != -1)return mem[i][j];
    if (a[i] == a[j]) {
        return mem[i][j] = solve(i + 1, j - 1);
    } else {
        int op1 = solve(i + 1, j) + 1;
        int op2 = solve(i, j - 1) + 1;
        return mem[i][j] = min(op1, op2);
    }
}

void Print(int i, int j) {
    if (i > j)return;
    if (a[i] == a[j]) {
        f += a[i];
        if (i != j)
            s = a[i] + s;
        Print(i + 1, j - 1);
    } else {
        int sol = solve(i,j);
        int op1= solve(i+1,j)+1;
        int op2 = solve(i,j-1);
        if(sol==op1){
            f+=a[i];
            s= a[i]+s;
            Print(i+1,j);
        }else{
            f+=a[j];
            s = a[j]+s;
           Print(i,j-1);
        }



    }

}


int main() {
    //    freopen("input.txt","rt",stdin);
    //    freopen("output.txt","wt",stdout);
    while(cin>>a){
        f = s="";
        n = a.length();
        mem = vector<vector<int>>(n,vector<int>(n,-1));
        cout<<solve(0,n-1)<<" ";
        Print(0,n-1);
        cout<<f<<s<<"\n";
    }


    return 0;
}
