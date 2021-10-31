#include<iostream>
using namespace std;
int t,s;
string n;
int main(){
	cin>>t;
	while(t--){
		s=0;
		cin>>n;
		for(int i=0;i<n.size();i++){
			for(int j=i+1;j<n.size();j++)
				if(((n[i]-'0')*10+(n[j]-'0'))%25==0) s=n.size()-i-2;
		}
		cout<<s<<endl;
	}
}
