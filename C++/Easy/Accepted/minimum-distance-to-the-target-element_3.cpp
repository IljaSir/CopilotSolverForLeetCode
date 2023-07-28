class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        
        int min = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                int diff = abs(i - start);
                if (diff < min) {
                    min = diff;
                }
            }
        }
        return min;
    }
};