class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return 0;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                res++;
                nums[i] = 0;
            }
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 2]) {
                res++;
                nums[i] = 0;
            }
        }
        return res;
    }
};