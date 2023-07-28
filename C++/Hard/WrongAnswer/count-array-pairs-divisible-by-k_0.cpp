class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        unordered_map<int, int> m;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % k == 0) {
                ans += m[0];
            }
            ans += m[k - nums[i] % k];
            m[nums[i] % k]++;
        }
        return ans;
    }
};