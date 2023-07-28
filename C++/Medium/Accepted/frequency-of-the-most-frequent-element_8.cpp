class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        long n = nums.size();
        long res = 1;
        long sum = 0;
        long i = 0;
        for (int j = 1; j < n; j++) {
            sum += (long)(j-i) * (nums[j] - nums[j-1]);
            while (sum > k) {
                sum -= nums[j] - nums[i];
                i++;
            }
            res = max(res, j-i+1);
        }
        return res;
    }
};