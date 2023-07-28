class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> ans;
        for(int n : nums) {
            while(n > 0) {
                ans.push_back(n % 10);
                n = n / 10;
            }
        }
        return ans;
    }
};