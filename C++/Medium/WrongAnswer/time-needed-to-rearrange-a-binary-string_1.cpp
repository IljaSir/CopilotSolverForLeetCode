class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int n = s.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '1') {
                ++cnt;
            }
        }
        return min(cnt, n - cnt);
    }
};