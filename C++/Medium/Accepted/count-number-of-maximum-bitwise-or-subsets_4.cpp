class Solution {
public:
    int countMaxOrSubsets(vector<int>& nums) {
        
        int n = nums.size();
        int maxOr = 0;
        int count = 0;
        for (int i = 0; i < (1 << n); i++) {
            int orValue = 0;
            for (int j = 0; j < n; j++) {
                if (i & (1 << j)) {
                    orValue |= nums[j];
                }
            }
            if (orValue > maxOr) {
                maxOr = orValue;
                count = 1;
            } else if (orValue == maxOr) {
                count++;
            }
        }
        return count;
    }
};