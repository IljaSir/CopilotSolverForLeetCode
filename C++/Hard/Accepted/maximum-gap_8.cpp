class Solution {
public:
    int maximumGap(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return 0;
        
        int maxNum = *max_element(nums.begin(), nums.end());
        int exp = 1, radix = 10;
        vector<int> buf(n);
        while (maxNum / exp > 0) {
            vector<int> cnt(radix);
            for (int i = 0; i < n; i++) {
                int digit = (nums[i] / exp) % radix;
                cnt[digit]++;
            }
            for (int i = 1; i < radix; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % radix;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            copy(buf.begin(), buf.end(), nums.begin());
            exp *= 10;
        }
        
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
};