class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums[i];
            int mappedNum = 0;
            int power = 0;
            while (num > 0) {
                mappedNum += mapping[num % 10] * pow(10, power++);
                num /= 10;
            }
            ans.push_back(mappedNum);
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};