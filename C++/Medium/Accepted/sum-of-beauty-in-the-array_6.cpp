class Solution {
public:
    int sumOfBeauties(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        vector<int> leftMax(n, 0), rightMin(n, 0);
        leftMax[0] = nums[0];
        rightMin[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = max(leftMax[i - 1], nums[i]);
            rightMin[n - i - 1] = min(rightMin[n - i], nums[n - i - 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMax[i - 1] && nums[i] < rightMin[i + 1]) {
                sum += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                sum += 1;
            }
        }
        return sum;
    }
};