class Solution {
public:
    int rearrangeCharacters(string s, string target) {
        
        int n = s.size();
        int m = target.size();
        int ans = 0;
        int i = 0;
        while (i < n) {
            int j = 0;
            while (i < n && j < m) {
                if (s[i] == target[j]) {
                    ++j;
                }
                ++i;
            }
            if (j == m) {
                ++ans;
            } else {
                break;
            }
        }
        return ans;
    }
};