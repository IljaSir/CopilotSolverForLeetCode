class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        vector<string> nums_str;
        for (int i = 0; i < nums.size(); i++) {
            nums_str.push_back(to_string(nums[i]));
        }
        sort(nums_str.begin(), nums_str.end(), [](const string &a, const string &b) {
            return a + b > b + a;
        });
        string res;
        for (string &s: nums_str) {
            res += s;
        }
        if (res[0] == '0') {
            return "0";
        } else {
            return res;
        }
    }
};