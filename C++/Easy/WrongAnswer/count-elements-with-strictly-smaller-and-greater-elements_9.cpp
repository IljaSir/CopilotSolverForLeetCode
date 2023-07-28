class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int left = -10e5;
            int right = 10e5;
            for (int j = 0; j < nums.size(); j++) {
                if (j == i) continue;
                if (nums[j] < nums[i]) {
                    left = max(left, nums[j]);
                } else {
                    right = min(right, nums[j]);
                }
            }
            if (left < nums[i] && nums[i] < right) {
                count++;
            }
        }
        return count;
    }
};