class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        
        int i = 0;
        int patches = 0;
        long long max = 0;
        while (max < n) {
            if (i < nums.size() && nums[i] <= max + 1) {
                max += nums[i];
                i++;
            } else {
                max += max + 1;
                patches++;
            }
        }
        return patches;
    }
};