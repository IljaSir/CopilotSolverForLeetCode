class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int n = s.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                count++;
            }
        }
        return (n - count);
    }
};