class Solution {
public:
    int singleNumber(vector<int>& nums) {
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums[j] & (1 << i)) {
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0) {
                result |= sum << i;
            }
        }
        return result;
    }
};