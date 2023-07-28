class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        int n = nums.size();
        long long ans = 0;
        unordered_map<int, int> cnt;
        for (int x : nums) {
            int y = x % k;
            if (y < 0) y += k;
            int z = (k - y) % k;
            ans += cnt[z];
            cnt[y]++;
        }
        return ans;
    }
};