class Solution {
public:
    int secondsToRemoveOccurrences(string s) {
        
        int ans = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '0') {
                count++;
            }
            else {
                if (count > 0) {
                    ans++;
                    count--;
                }
            }
        }
        return ans;
    }
};