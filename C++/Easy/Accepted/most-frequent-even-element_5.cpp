class Solution {
public:
    int mostFrequentEven(vector<int>& nums) {
        
        int maxCount = 0;
        int maxNum = -1;
        vector<int> count(100001, 0);
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                count[nums[i]]++;
                if (count[nums[i]] > maxCount) {
                    maxCount = count[nums[i]];
                    maxNum = nums[i];
                } else if (count[nums[i]] == maxCount) {
                    maxNum = min(maxNum, nums[i]);
                }
            }
        }
        return maxNum;
    }
};