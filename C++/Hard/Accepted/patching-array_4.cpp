class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        
        int i = 0, patch = 0;
        long long x = 1;
        while (x <= n) {
            if (i < nums.size() && nums[i] <= x) {
                x += nums[i++];
            } else {
                x += x;
                patch++;
            }
        }
        return patch;
    }
};