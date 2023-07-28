class Solution {
public:
    int totalStrength(vector<int>& strength) {
        
        int n = strength.size();
        int mod = 1e9+7;
        vector<int> left(n);
        vector<int> right(n);
        stack<int> s;
        for(int i=0;i<n;i++){
            while(!s.empty() && strength[s.top()]>=strength[i]) s.pop();
            left[i] = s.empty()?-1:s.top();
            s.push(i);
        }
        while(!s.empty()) s.pop();
        for(int i=n-1;i>=0;i--){
            while(!s.empty() && strength[s.top()]>=strength[i]) s.pop();
            right[i] = s.empty()?n:s.top();
            s.push(i);
        }
        long long ans = 0;
        for(int i=0;i<n;i++){
            ans = (ans + (long long)strength[i]*(i-left[i])*(right[i]-i))%mod;
        }
        return ans;
    }
};