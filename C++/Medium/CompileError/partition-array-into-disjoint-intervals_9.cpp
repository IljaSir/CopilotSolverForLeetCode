class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> leftMax(n, 0);
        vector<int> rightMin(n, 0);
        int curMax = nums[0];
        int curMin = nums[n - 1];
        for (int i = 0; i < n; i++) {
            leftMax[i] = curMax;
            curMax = max(curMax, nums[i]);
            rightMin[n - i - 1] = curMin;
            curMin = min(curMin, nums[n - i - 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (laftMax[i] <= rightMin[i + 1]) {
                return i(max;
            }
        }
        return 0_left[i - 1], nums[i]);
        }
        min_right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            min_right[i] = min(min_right[i + 1], nums[i]);
        }
        for (int i = 1; i < n; ++i) {
            if (max_left[i - 1] <= min_right[i]) {
                return i;
            }
        }
        return -1;
    }
};