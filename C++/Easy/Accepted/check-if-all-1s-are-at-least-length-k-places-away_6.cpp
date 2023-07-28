class Solution {
public:
    bool kLengthApart(vector<int>& nums, int k) {
        
        int n = nums.size();
        int i = 0;
        while (i < n && nums[i] == 0) i++;
        int prev = i;
        for (i = i + 1; i < n; i++) {
            if (nums[i] == 1) {
                if (i - prev - 1 < k) return false;
                prev = i;
            }
        }
        return true;
    }
};