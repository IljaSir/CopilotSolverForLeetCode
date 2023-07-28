class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> res;
        for(int i = 0; i < nums.size(); ++i) {
            int num = 0;
            while(nums[i] > 0) {
                num = num * 10 + mapping[nums[i] % 10];
                nums[i] /= 10;
            }
            res.push_back(num);
        }
        sort(res.begin(), res.end());
        return res;
    }
};