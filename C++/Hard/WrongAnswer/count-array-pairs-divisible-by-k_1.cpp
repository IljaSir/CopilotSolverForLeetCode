class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        unordered_map<int, long long> m;
        long long ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            ans += m[(k - nums[i] % k) % k];
            m[nums[i] % k]++;
        }
        return ans;
    }
};