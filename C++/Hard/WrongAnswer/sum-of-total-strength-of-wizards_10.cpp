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
            s.push(i);
        }
        while(!s.empty()) s.pop();
        for(int i=n-1;i>=0;i--){
            while(!s.empty() && strength[s.top()]>=strength[i]){
                s.pop();
            }
            if(!s.empty()){
                right[i] = s.top();
            }
            s.push(i);
        }
        int ans = 0;
        int mod = 1e9+7;
        for(int i=0;i<n;i++){
            ans = (ans + 1LL*strength[i]*(right[i]-i+1)*(i-left[i]+1)) % mod;
        }
        return ans;
    }
};