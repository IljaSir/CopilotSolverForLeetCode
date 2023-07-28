class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        
        int cnt = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] > nums[i+1]) {
                if (i > 0 && nums[i+1] < nums[i-1]) nums[i+1] = nums[i];
                else nums[i] = nums[i+1];
                cnt++;
            }
            if (cnt > 1) return false;
        }
        return true;
    }
};