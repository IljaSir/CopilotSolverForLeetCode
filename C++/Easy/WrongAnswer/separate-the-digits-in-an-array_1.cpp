class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> result;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            while (num > 0) {
                result.push_back(num % 10);
                num /= 10;
            }
        }
        return result;
    }
};