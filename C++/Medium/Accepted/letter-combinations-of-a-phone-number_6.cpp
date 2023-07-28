class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        vector<string> ret;
        if (digits.empty()) return ret;
        vector<vector<char>> dict = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
        };
        ret.push_back("");
        for (auto d : digits) {
            vector<string> tmp;
            for (auto c : dict[d - '2']) {
                for (auto s : ret) {
                    tmp.push_back(s + c);
                }
            }
            ret.swap(tmp);
        }
        return ret;
    }
};