class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        
        int lastOne = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 1) {
                if (lastOne != -1 && i - lastOne - 1 < k) {
                    return false;
                }
                lastOne = i;
            }
        }
        return true;
    }
};