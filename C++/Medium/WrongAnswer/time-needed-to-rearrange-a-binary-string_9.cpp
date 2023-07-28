class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int i = 0, n = s.size();
        int cnt = 0;
        while (i < n) {
            while (i < n && s[i] == '0') {
                ++i;
            }
            if (i == n) {
                break;
            }
            while (i < n && s[i] == '1') {
                ++i;
                ++cnt;
            }
        }
        return cnt;
    }
};