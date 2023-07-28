class Solution {
public:
    int bestRotation(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> point(n, 0);
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= i) {
                point[0] += 1;
                point[i - nums[i] + 1] -= 1;
            } else {
                point[i + 1] += 1;
                point[i - nums[i] + 1] -= 1;
            }
        }
        for (int i = 1; i < n; ++i) {
            point[i] += point[i - 1];
        }
        int max_point = 0;
        int max_index = 0;
        for (int i = 0; i < n; ++i) {
            if (point[i] > max_point) {
                max_point = point[i];
                max_index = i;
            }
        }
        return max_index;
    }
};