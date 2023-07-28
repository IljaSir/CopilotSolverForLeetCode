class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        std::sort(nums.begin(), nums.end(), [](int a, int b) {
            string s1 = std::to_string(a);
            string s2 = std::to_string(b);
            return s1 + s2 > s2 + s1;
        });
        if (nums[0] == 0) return "0";
        string res;
        for (int num : nums) {
            res += std::to_string(num);
        }
        return res;
    }
};