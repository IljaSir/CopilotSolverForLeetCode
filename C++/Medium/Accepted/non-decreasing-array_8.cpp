class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return true;
        int cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i-1]) {
                if (++cnt > 1) return false;
                if (i-2 >= 0 && nums[i] < nums[i-2]) nums[i] = nums[i-1];
            }
        }
        return true;
    }
};