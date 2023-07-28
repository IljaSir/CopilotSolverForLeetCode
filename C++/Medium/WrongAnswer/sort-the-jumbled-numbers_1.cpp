class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> res;
        for (int num : nums) {
            int mapped = 0;
            while (num > 0) {
                mapped = mapped * 10 + mapping[num % 10];
                num /= 10;
            }
            res.push_back(mapped);
        }
        sort(res.begin(), res.end());
        return res;
    }
};