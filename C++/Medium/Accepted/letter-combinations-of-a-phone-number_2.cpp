class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> res;
        if(digits.empty()) return res;
        unordered_map<char, string> mp;
        mp['2'] = "abc";
        mp['3'] = "def";
        mp['4'] = "ghi";
        mp['5'] = "jkl";
        mp['6'] = "mno";
        mp['7'] = "pqrs";
        mp['8'] = "tuv";
        mp['9'] = "wxyz";
        res.push_back("");
        for(int i = 0; i < digits.size(); ++i) {
            vector<string> tmp;
            for(int j = 0; j < mp[digits[i]].size(); ++j) {
                for(int k = 0; k < res.size(); ++k) {
                    tmp.push_back(res[k] + mp[digits[i]][j]);
                }
            }
            res = tmp;
        }
        return res;
    }
};