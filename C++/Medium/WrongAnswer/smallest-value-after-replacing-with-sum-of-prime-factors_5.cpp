class Solution {
public:
    int smallestValue(int n) {
        
        vector<int> prime;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                prime.push_back(i);
                while(n%i==0){
                    n/=i;
                }
            }
        }
        if(n>1){
            prime.push_back(n);
        }
        int ans=0;
        for(int i=0; i<prime.size(); i++){
            ans+=prime[i];
        }
        return ans;
    }
};