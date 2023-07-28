class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            int newNum = 0;
            while (num) {
                newNum = newNum * 10 + mapping[num % 10];
                num /= 10;
            }
            ans.push_back(newNum);
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};