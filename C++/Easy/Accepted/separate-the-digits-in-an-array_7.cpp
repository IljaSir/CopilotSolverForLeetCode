class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> result;
        for (int num: nums) {
            int temp = num;
            vector<int> digits;
            while (temp > 0) {
                digits.push_back(temp % 10);
                temp /= 10;
            }
            for (int i = digits.size() - 1; i >= 0; i--) {
                result.push_back(digits[i]);
            }
        }
        return result;
    }
};