class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> result;
        for (auto n : nums) {
            while (n > 0) {
                result.push_back(n % 10);
                n /= 10;
            }
        }
        return result;
    }
};