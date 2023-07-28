class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        
        int n = nums.size();
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        int ans = min + n - max - 1;
        if (min > max) {
            ans--;
        }
        return ans;
    }
};