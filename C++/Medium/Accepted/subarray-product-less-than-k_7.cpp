class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        
        int n = nums.size();
        int i = 0, j = 0, sum = 0;
        int product = 1;
        while (j < n) {
            product *= nums[j];
            while (i <= j && product >= k) {
                product /= nums[i];
                i++;
            }
            sum += j - i + 1;
            j++;
        }
        return sum;
    }
};