#include"bits/stdc++.h"
#define FIO ios_base::sync_with_stdio(0);cin.tie(0);
using namespace std;
typedef long long ll;

const int N=1e5+5, M=1e3+5, MOD=1e9+7,OO=0x3f3f3f3f;
const ll LOO=0x3f3f3f3f3f3f3f3f;
const long double EPS=1e-8;

ll egcd(ll a, ll b, ll &x, ll &y){ /// ax + by = gcd(a,b)
    if(!b){
        x=1;
        y=0;
        return a;
    }
    ll g=egcd(b,a%b,y,x);
    y-=(a/b)*x;
    return g;
}

ll modInverse(ll a, ll m){ /// (a/b)%m = ((a%m)*(modInverse(b)%m))%m
    ll x,y,g;
    g=egcd(a,m,x,y);
    if(g>1)
        return -1;
    return (x+m)%m;
}

ll fixMod(ll a, ll m){
    return (a + m)%m;
}

ll pushBack(ll h, ll x, ll p, char ch){
    return (((h*x)%p)+ch)%p;
}

ll pushFront(ll h, ll xp, ll p, char ch){ // xp=XP[len]
    return (h+(xp*ch)%p)%p;
}

ll popBack(ll h, ll x, ll p, char ch){
    return (fixMod(h-ch,p)*modInverse(x,p))%p;
}

ll popFront(ll h, ll xp, ll p, char ch){ // xp=XP[len-1]
    return fixMod(h-((xp*ch)%p),p);
}

int main(){
    FIO
    //    freopen("input.txt","rt",stdin);
    //    freopen("output.txt","wt",stdout);
    int x=128, p1=1e9+7 ,p2 = 1e9+9;
    vector<ll>XP1(1e5+1), XP2(1e5+1);
    XP2[0]=1;
    XP1[0]=1;
    for(int i=1; i<=100000; i++){
        XP1[i]=(XP1[i-1]*x)%p1;
        XP2[i]=(XP2[i-1]*x)%p2;


    }
    int t;
    cin>>t;
    while(t-->0){
        int n;
        int k;
        string a;
        cin>>n>>k>>a;
        ll h1 =0;
        ll h2 =0;
        set<pair<ll,ll>>st;
        for(int i =0; i<k; i++){
            h1 = pushBack(h1,x,p1,a[i]);
            h2 = pushBack(h2,x,p2,a[i]);

        }
        st.insert({h1,h2});
        //hPrev contains the first elements //now it contains aa

        for(int i = k; i<n; i++){
            h1  = popFront(h1,XP1[k-1],p1,a[i-k]); //a
            h1 = pushBack(h1,x,p1,a[i]);
            h2  = popFront(h2,XP2[k-1],p2,a[i-k]); //a
            h2 = pushBack(h2,x,p2,a[i]);
            st.insert({h1,h2});
        }
        cout<<(int)st.size()<<"\n";



    }



    return 0;
}
