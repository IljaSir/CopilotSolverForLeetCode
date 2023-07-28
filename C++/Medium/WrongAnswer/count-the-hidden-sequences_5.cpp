class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
        
        int n = differences.size();
        vector<int> f(n+1, 0);
        f[0] = 1;
        int mod = 1e9 + 7;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += differences[i];
            f[i+1] = (f[i+1] + f[i]) % mod;
            if(sum >= lower){
                int l = max(0, lower - sum + differences[i]);
                int r = min(upper - sum, differences[i]);
                if(l <= r){
                    f[i+1] = (f[i+1] + f[i] * (r - l + 1)) % mod;
                }
            }
        }
        return f[n];
    }
};