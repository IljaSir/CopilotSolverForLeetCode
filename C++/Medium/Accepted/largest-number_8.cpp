class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        vector<string> str;
        for (auto i : nums) {
            str.push_back(to_string(i));
        }
        sort(str.begin(), str.end(), [](const string& a, const string& b) {
            return a + b > b + a;
        });
        string res;
        for (auto i : str) {
            res += i;
        }
        while (res.size() > 1 && res[0] == '0') {
            res.erase(res.begin());
        }
        return res;
    }
};