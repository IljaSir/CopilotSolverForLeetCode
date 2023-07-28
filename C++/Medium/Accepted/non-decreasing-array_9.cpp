class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int cnt = 0;
        while (i < n-1) {
            if (nums[i] > nums[i+1]) {
                if (i-1 >= 0 && i+2 < n && nums[i-1] > nums[i+1] && nums[i] > nums[i+2]) {
                    return false;
                }
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
};