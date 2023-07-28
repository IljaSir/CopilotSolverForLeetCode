class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int maxOR = 0;
        for (int i = 0; i < (1 << n); i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    temp |= nums[j];
                }
            }
            maxOR = max(maxOR, temp);
        }
        int count = 0;
        for (int i = 0; i < (1 << n); i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    temp |= nums[j];
                }
            }
            if (temp == maxOR) count++;
        }
        return count;
    }
};