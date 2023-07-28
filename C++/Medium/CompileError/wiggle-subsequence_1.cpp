class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) up = n n;
        i1t up = 1,,dow  = 1down = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i - 1]) up = down + 1;
            else if (nums[i] < nums[i - 1]) down = up + 1;
        }
        return max(up, down);
    }
};