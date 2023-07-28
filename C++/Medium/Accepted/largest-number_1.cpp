class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        sort(nums.begin(), nums.end(), [](int a, int b) {
            string sa = to_string(a);
            string sb = to_string(b);
            return sa + sb > sb + sa;
        });
        string ans;
        for (int i = 0; i < nums.size(); i++) {
            ans += to_string(nums[i]);
        }
        if (ans[0] == '0') {
            return "0";
        }
        return ans;
    }
};