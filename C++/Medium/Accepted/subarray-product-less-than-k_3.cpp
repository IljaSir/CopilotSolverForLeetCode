class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        
        int i = 0, j = 0, res = 0, prod = 1;
        while (j < nums.size()) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i++];
            }
            res += j - i + 1;
            j++;
        }
        return res;
    }
};