#include<bits/stdc++.h>

using namespace std;
typedef long long ll;


const int N = 1e5 + 5;
int coins[] = {1, 5, 10, 25, 50};


string a,b;
int n,mn= 1e5+1, mx =0;
int freq[N];
vector<ll>mem;


//int solve(int i, int j){
//    if(i==n || j==m) return 0;
//    if(mem[i][j]!=-1)
//        return mem[i][j];
//    if(a[i]==b[j])
//        return mem[i][j]=1+solve(i+1,j+1);
//    else{
//        int op1=solve(i,j+1);
//        int op2=solve(i+1,j);
//        return mem[i][j]=max(op1,op2);
//    }

ll solve(int i ){
    if(i>mx)return 0;
    if(mem[i]!=-1)return mem[i];
    ll op1 = solve(i + 2) + ((ll)i*freq[i]);
    ll op2 = solve(i+1);
    return mem[i]= max(op1,op2);
}



int main(){
    //    freopen("input.txt","rt",stdin);
    //    freopen("output.txt","wt",stdout);
    cin>>n;
    int x;
    for(int i =0; i<n; i++){
        cin>>x;
        mn =min(mn,x);
        mx= max(mx,x);
        freq[x]++;
    }
    mem=vector<ll>(mx+1,-1);
    cout<<solve(mn)<<"\n";

    return 0;
}
