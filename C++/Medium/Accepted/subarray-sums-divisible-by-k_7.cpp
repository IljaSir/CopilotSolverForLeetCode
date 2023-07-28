class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        
        int n = nums.size();
        int res = 0;
        vector<int> cnt(k, 0);
        cnt[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int m = sum % k;
            if (m < 0) m += k;
            res += cnt[m];
            cnt[m]++;
        }
        return res;
    }
};