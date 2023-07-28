class Solution {
public:
    int maxScore(string s) {
        
        int n = s.size();
        int z = 0, o = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                z++;
            } else {
                o++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                z--;
            } else {
                o--;
            }
            ans = max(ans, z + o);
        }
        return ans;
    }
};