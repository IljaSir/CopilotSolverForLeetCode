class Solution {
public:
    long long countGood(vector<int>& nums, int k) {
        
        int n = nums.size();
        long long ans = 0;
        int cnt = 0;
        unordered_map<int, int> m;
        m[0] = 1;
        for (int i = 0; i < n; ++i) {
            cnt += nums[i] % 2;
            ans += m[cnt - k];
            ++m[cnt];
        }
        return ans;
    }
};