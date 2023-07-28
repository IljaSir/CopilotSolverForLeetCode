class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int lastBit = xorResult - (xorResult & (xorResult - 1));
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if (num & lastBit) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return {num1, num2};
    }
};