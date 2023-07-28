class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            int count = 0;
            while (n > 0) {
                if (n % 2 == 1) {
                    ans++;
                }
                n = n / 2;
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return ans + max - 1;
    }
};