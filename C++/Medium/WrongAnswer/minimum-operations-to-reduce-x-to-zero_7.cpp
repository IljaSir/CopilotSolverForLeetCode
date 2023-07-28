class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int i = 0, j = 0;
        int sum = 0;
        int res = INT_MAX;
        while (j < n) {
            sum += nums[j];
            while (sum > x && i <= j) {
                sum -= nums[i];
                i++;
            }
            if (sum == x) {
                res = min(res, n - (j - i + 1));
            }
            j++;
        }
        return res == INT_MAX ? -1 : res;
    }
};