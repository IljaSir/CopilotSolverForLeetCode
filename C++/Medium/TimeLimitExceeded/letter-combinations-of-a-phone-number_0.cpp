class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> result;
        if (digits.empty()) return result;
        vector<string> dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        vector<int> index(digits.size(), 0);
        int i = 0;
        while (i >= 0) {
            if (i == digits.size()) {
                string temp;
                for (int j = 0; j < digits.size(); ++j) {
                    temp.push_back(dict[digits[j] - '2'][index[j]]);
                }
                result.push_back(temp);
                --i;
            }
            else if (index[i] < dict[digits[i] - '2'].size()) {
                ++i;
            }
            else {
                index[i] = 0;
                --i;
            }
        }
        return result;
    }
};