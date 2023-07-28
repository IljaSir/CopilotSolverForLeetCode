class Solution {
public:
    int maxPower(string s) {
        
        int ans = 0;
        for (int i = 0; i < s.size(); ++i) {
            int j = i;
            while (j < s.size() && s[j] == s[i]) {
                ++j;
            }
            ans = max(ans, j - i);
            i = j - 1;
        }
        return ans;
    }
};