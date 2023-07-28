class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        int i = 0, j = 0, sum = 0, minLen = INT_MAX;
        while (j < n) { // expand the window
            sum += nums[j];
            while (sum >= target) { // shrink the window
                minLen = min(minLen, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == INT_MAX ? 0 : minLen;
    }
};