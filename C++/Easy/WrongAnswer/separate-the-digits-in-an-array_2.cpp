class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums[i];
            while (n > 0) {
                res.push_back(n % 10);
                n /= 10;
            }
        }
        return res;
    }
};