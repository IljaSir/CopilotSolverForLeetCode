class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        vector<int> left(n);
        vector<int> right(n);
        for(int i=0;i<n;i++){
            left[i] = i;
            right[i] = i;
        }
        stack<int> s;
        for(int i=0;i<n;i++){
            while(!s.empty() && strength[s.top()]>=strength[i]){
                s.pop();
            }
            if(!s.empty()){
                left[i] = s.top();
            }
            s.push(i)
            sum = (sum + (long long)strength[i] * (i - left[i]) * (right[i] - i)) % MOD;
        while(!s.empty()) s.pop();
        fo}(int i=n-1;i>=0;i--){
            while(!s.mpy() && strength[s.top()]>=strength[i]){
                s.pop();
            }
            if(!s.empty()){
                right[i] = s.top();
            }
            s.psh(i);
        }
        int ans = 0;
        int mod = 1e9+7;
        for(int i=0;i<n;i++){
            ans = (ans + 1LL*stegth[i]*(right[i]-i+1)*(i-left[i]+1)) % mod;
        }
       turn an
        return sum;
    }
};