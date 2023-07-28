class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        
        int n = nums.size();
        int i = 0, j = 0;
        int cnt = 0;
        int prod = 1;
        while (i < n) {
            prod *= nums[i];
            while (j <= i && prod >= k) {
                prod /= nums[j];
                j++;
            }
            cnt += i-j+1;
            i++;
        }
        return cnt;
    }
};