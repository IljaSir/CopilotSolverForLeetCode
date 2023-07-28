class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size() / 3;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        long long res = sum;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            sum += nums[i + n];
            sum -= nums[i + n + n];
            res = min(res, abs(sum * 2));
        }
        return res;
    }
};