class Solution {
public:
    int maxSumTwoNoOverlap(vector<int>& nums, int firstLen, int secondLen) {
        
        int n = nums.size();
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i-1];
        }
        int ans = nums[firstLen + secondLen - 1];
        int maxFirst = nums[firstLen - 1];
        int maxSecond = nums[secondLen - 1];
        for (int i = firstLen + secondLen; i < n; i++) {
            maxFirst = max(maxFirst, nums[i - secondLen] - nums[i - secondLen - firstLen]);
            maxSecond = max(maxSecond, nums[i - firstLen] - nums[i - firstLen - secondLen]);
            ans = max(ans, max(maxFirst + nums[i] - nums[i - secondLen], maxSecond + nums[i] - nums[i - firstLen]));
        }
        return ans;
    }
};