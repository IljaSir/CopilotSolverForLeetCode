class Solution {
public:
    int mostFrequent(vector<int>& nums, int key) {
        
        int n = nums.size();
        int ans = -1;
        int maxCount = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == key) {
                if (ans == -1) {
                    ans = nums[i + 1];
                    maxCount = 1;
                } else if (ans == nums[i + 1]) {
                    ++maxCount;
                } else {
                    --maxCount;
                    if (maxCount == 0) {
                        ans = nums[i + 1];
                        maxCount = 1;
                    }
                }
            }
        }
        return ans;
    }
};