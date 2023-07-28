class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        if (digits.empty()) return {};
        vector<string> res;
        vector<string> dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.push_back("");
        for (int i = 0; i < digits.size(); i++) {
            vector<string> tmp;
            string str = dict[digits[i] - '2'];
            for (int j = 0; j < str.size(); j++) {
                for (int k = 0; k < res.size(); k++) {
                    tmp.push_back(res[k] + str[j]);
                }
            }
            res = tmp;
        }
        return res;
    }
};