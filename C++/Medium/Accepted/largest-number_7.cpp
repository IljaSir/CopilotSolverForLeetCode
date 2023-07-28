class Solution {
public:
    string largestNumber(vector<int>& nums) {
        
        vector<string> numStrs;
        for (int num : nums) {
            numStrs.push_back(to_string(num));
        }
        sort(numStrs.begin(), numStrs.end(), [](const string& s1, const string& s2) {
            return s1 + s2 > s2 + s1;
        });
        string res;
        for (string& numStr : numStrs) {
            res += numStr;
        }
        while (res.size() > 1 && res[0] == '0') {
            res.erase(0, 1);
        }
        return res;
    }
};