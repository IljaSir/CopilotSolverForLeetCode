class Solution {
public:
    int arithmeticTriplets(vector<int>& nums, int diff) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n - 2; ++i) {
            int j = i + 1;
            int k = i + 2;
            while (k < n) {
                if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                    ans++;
                    k++;
                } else if (nums[k] - nums[j] < diff) {
                    k++;
                } else {
                    j++;
                    if (j == k) k++;
                }
            }
        }
        return ans;
    }
};