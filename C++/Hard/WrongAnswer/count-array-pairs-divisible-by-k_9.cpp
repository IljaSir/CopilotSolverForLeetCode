class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        unordered_map<int, int> m;
        for (const auto& num : nums) {
            int r = num % k;
            int t = (k - r) % k;
            ans += m[t];
            m[r]++;
        }
        return ans;
    }
};