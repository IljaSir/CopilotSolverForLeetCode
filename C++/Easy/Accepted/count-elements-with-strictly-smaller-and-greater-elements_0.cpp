class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            int left = 0, right = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                if (nums[i] > nums[j]) left++;
                if (nums[i] < nums[j]) right++;
            }
            if (left > 0 && right > 0) count++;
        }
        return count;
    }
};