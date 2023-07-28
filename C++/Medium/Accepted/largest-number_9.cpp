class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        sort(nums.begin(), nums.end(), [](int a, int b){
            auto sa = to_string(a), sb = to_string(b);
            return sa + sb > sb + sa;
        });
        string s;
        for (auto n : nums) s += to_string(n);
        while (s.size() > 1 && s[0] == '0') s.erase(s.begin());
        return s;
    }
};