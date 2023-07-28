class Solution {
public:
    int maxProduct(vector<int>& nums) {
        
        int n = nums.size();
        int max_ending_here = 1;
        int min_ending_here = 1;
        int max_so_far = INT_MIN;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                max_ending_here = max_ending_here * nums[i];
                min_ending_here = min(min_ending_here * nums[i], 1);
            } else if (nums[i] == 0) {
                max_ending_here = 1;
                min_ending_here = 1;
            } else {
                int temp = max_ending_here;
                max_ending_here = max(min_ending_here * nums[i], 1);
                min_ending_here = temp * nums[i];
            }
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
        }
        return max_so_far;
    }
};