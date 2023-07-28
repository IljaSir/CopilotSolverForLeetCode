class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long n = nums.size();
        long long ans = 0;
        long long i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                long long j = i + 1;
                while (j < n && nums[j] == 0) {
                    ans += j - i;
                    j++;
                }
                ans += j - i;
                i = j;
            } else {
                i++;
            }
        }
        return ans;
    }
};