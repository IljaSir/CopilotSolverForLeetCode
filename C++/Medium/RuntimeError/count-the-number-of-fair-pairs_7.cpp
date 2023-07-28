class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        int l = 0;
        int r = 0;
        long long sum = 0;
        long long res = 0;
        long long cnt = 0;
        for (int i = 0; i < n; i++) {
            while (l < n && sum < lower) {
                sum += nums[l];
                l++;
            }
            if (l == n) break;
            while (r < n && sum <= upper) {
                sum += nums[r];
                r++;
            }
            if (sum > upper) {
                sum -= nums[r-1];
                r--;
            }
            if (l < r) {
                cnt = r - l;
                res += (cnt * (cnt - 1)) / 2;
            }
            sum -= nums[i];
        }
        return res;
    }
};