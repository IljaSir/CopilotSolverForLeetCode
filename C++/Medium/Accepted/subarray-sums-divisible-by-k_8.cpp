class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> prefix(n, 0);
        prefix[0] = nums[0];
        for(int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        unordered_map<int, int> m;
        m[0] = 1;
        int ans = 0;
        for(int i = 0; i < n; ++i) {
            int mod = prefix[i] % k;
            if(mod < 0) mod += k;
            ans += m[mod];
            ++m[mod];
        }
        return ans;
    }
};