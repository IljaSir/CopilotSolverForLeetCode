class Solution {
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        
        vector<bool> res;
        if(threshold==0) {
            for(auto q:queries) res.push_back(true);
            return res;
        }
        vector<bool> isPrime(n+1,true);
        isPrime[0] = isPrime[1] = false;
        for(int i=2;i<=n;i++) {
            if(isPrime[i]) {
                for(int j=i+i;j<=n;j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(auto q:queries) {
            bool found = false;
            for(int i=threshold+1;i<=n;i++) {
                if(isPrime[i] && q[0]%i==0 && q[1]%i==0) {
                    found = true;
                    break;
                }
            }
            res.push_back(found);
        }
        return res;
    }
};