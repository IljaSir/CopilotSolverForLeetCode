class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        int n = nums.size();
        int i = 0;
        int j = 0;
        int sum = start;
        int res = 0;
        while (i < n && j < n) {
            sum = sum ^ nums[i];
            if (sum == goal) {
                res++;
                i++;
                j++;
                sum = start;
            } else if (sum > goal) {
                sum = sum ^ nums[j];
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
};