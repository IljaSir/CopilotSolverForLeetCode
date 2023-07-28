class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int n = nums.size();
        int count = 0;
        int maxCount = 0;
        int maxKey = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] == key) {
                if (nums[i] == maxKey) {
                    ++count;
                } else {
                    count = 1;
                    maxKey = nums[i];
                }
                maxCount = max(maxCount, count);
            }
        }
        return maxKey;
    }
};