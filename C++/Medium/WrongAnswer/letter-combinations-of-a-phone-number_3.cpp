class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> result;
        if (digits.size() == 0) return result;
        vector<string> dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.size();
        int i = 0;
        while (i < n && digits[i] == '1') i++;
        if (i == n) return result;
        string s;
        s.push_back(dict[digits[i] - '2'][0]);
        result.push_back(s);
        for (i = i + 1; i < n; i++) {
            if (digits[i] == '1') continue;
            vector<string> tmp;
            for (int j = 0; j < dict[digits[i] - '2'].size(); j++) {
                for (int k = 0; k < result.size(); k++) {
                    string s = result[k];
                    s.push_back(dict[digits[i] - '2'][j]);
                    tmp.push_back(s);
                }
            }
            result = tmp;
        }
        return result;
    }
};