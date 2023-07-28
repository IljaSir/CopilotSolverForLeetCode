class Solution {
public:
    string sortString(string s) {
        
        int count[26] = {0};
        for (auto c : s) {
            ++count[c - 'a'];
        }
        string result;
        while (result.size() < s.size()) {
            for (int i = 0; i < 26; ++i) {
                if (count[i]-- > 0) {
                    result.push_back(i + 'a');
                }
            }
            for (int i = 25; i >= 0; --i) {
                if (count[i]-- > 0) {
                    result.push_back(i + 'a');
                }
            }
        }
        return result;
    }
};