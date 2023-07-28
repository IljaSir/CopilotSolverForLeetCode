class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> sum(n+1, 0);
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + arr[i-1];
        }
        unordered_map<int, int> mp;
        long long ans = INT_MAX;
        for(int i=0; i<n; i++){
            int current = sum[i+1] - sum[i];
            int need = (i+1)*k - current;
            if(mp.count(need)){
                ans = min(ans, (long long)mp[need] + (i+1));
            }
            mp[current]++;
        }
        return ans == INT_MAX ? -1 : ans;
    }
};