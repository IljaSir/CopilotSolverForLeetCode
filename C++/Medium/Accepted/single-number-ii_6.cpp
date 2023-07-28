class Solution {
public:
    int singleNumber(vector<int>& nums) {
        
        int result = 0;
        for (int i = 0; i < sizeof(int) * 8; i++) {
            int sum = 0;
            for (int j = 0; j < nums.size(); j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }
};