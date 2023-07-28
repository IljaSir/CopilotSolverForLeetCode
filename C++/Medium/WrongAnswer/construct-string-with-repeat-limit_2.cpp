class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        string result;
        int n = s.size();
        int left = 0;
        while (left < n) {
            int right = left + 1;
            while (right < n && s[right] == s[left]) {
                ++right;
            }
            int count = right - left;
            result += string(min(count, repeatLimit), s[left]);
            left = right;
        }
        return result;
    }
};