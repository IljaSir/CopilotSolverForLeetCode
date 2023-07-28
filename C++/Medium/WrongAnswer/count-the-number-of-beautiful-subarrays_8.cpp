class Solution {
public:
    long long beautifulSubarrays(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        vector<int> cnt(n+1);
        cnt[0] = 1;
        int odd = 0;
        for (int i = 0; i < n; i++) {
            odd += nums[i] % 2;
            res += cnt[odd];
            cnt[odd]++;
        }
        return res;
    }
};