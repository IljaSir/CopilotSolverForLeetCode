class Solution {
public:
    vector<int> separateDigits(vector<int>& nums) {
        
        vector<int> ans;
        for (int i=0; i<nums.size(); i++) {
            int num = nums[i];
            while (num > 0) {
                ans.push_back(num%10);
                num /= 10;
            }
        }
        return ans;
    }
};