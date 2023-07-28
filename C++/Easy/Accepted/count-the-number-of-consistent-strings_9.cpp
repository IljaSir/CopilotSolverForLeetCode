class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        
        int res = 0;
        for (auto s : words) {
            int i = 0;
            for (; i < s.length(); ++i) {
                if (allowed.find(s[i]) == string::npos) {
                    break;
                }
            }
            if (i == s.length()) {
                ++res;
            }
        }
        return res;
    }
};