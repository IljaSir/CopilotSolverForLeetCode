class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int ones = 0;
        for (int x : nums) {
            if (x == 1) {
                ones++;
            }
        }
        int i = 0;
        for (int j = 0; j < ones; j++) {
            if (nums[j] == 1) {
                i++;
            }
        }
        int ans = ones - i;
        for (int j = ones; j < n; j++) {
            if (nums[j] == 1) {
                i++;
            }
            if (nums[j - ones] == 1) {
                i--;
            }
            ans = min(ans, ones - i);
        }
        return ans;
    }
};