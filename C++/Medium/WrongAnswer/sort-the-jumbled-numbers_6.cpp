class Solution {
public:
    vector<int> sortJumbled(vector<int>& mapping, vector<int>& nums) {
        
        vector<int> res;
        for(auto n : nums) {
            int val = 0;
            while(n) {
                val = val*10 + mapping[n%10];
                n /= 10;
            }
            res.push_back(val);
        }
        sort(res.begin(), res.end());
        return res;
    }
};