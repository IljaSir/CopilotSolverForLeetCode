class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = n - 1;
        int count = 0;
        int maxCount = 0;
        while (i < j) {
            if (nums[i] < 0) {
                i++;
                continue;
            }
            while (j > i && nums[j] > 0) {
                j--;
            }
            count = j - i + 1;
            maxCount = max(maxCount, count);
            i++;
        }
        return maxCount;
    }
};