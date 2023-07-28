class Solution {
public:
    string makeLargestSpecial(string s) {
        
        int count = 0, i = 0;
        vector<string> res;
        for (int j = 0; j < s.size(); ++j) {
            count += s[j] == '1' ? 1 : -1;
            if (count == 0) {
                res.push_back('1' + makeLargestSpecial(s.substr(i + 1, j - i - 1)) + '0');
                i = j + 1;
            }
        }
        sort(res.begin(), res.end(), greater<string>());
        return accumulate(res.begin(), res.end(), string());
    }
};