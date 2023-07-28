class Solution {
public:
    string makeFancyString(string s) {
        
        string result;
        int count = 1;
        for (int i = 1; i < s.size(); ++i) {
            if (s[i] == s[i-1]) {
                ++count;
            } else {
                count = 1;
            }
            if (count < 3) {
                result += s[i];
            }
        }
        if (s.size() > 0) {
            result = s[0] + result;
        }
        return result;
    }
};