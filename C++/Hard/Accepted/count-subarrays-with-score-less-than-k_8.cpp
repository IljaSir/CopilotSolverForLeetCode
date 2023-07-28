class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        
        long long res = 0;
        long long sum = 0;
        int n = nums.size();
        int i = 0;
        int j = 0;
        while (j < n) {
            sum += nums[j];
            while (i < n && sum * (j - i + 1) >= k) {
                sum -= nums[i];
                i++;
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
};