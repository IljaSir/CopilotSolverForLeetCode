class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> result;
        for (int num : nums) {
            while (num > 0) {
                result.push_back(num%10);
                num /= 10;
            }
        }
        reverse(result.begin(), result.end());
        return result;
    }
};