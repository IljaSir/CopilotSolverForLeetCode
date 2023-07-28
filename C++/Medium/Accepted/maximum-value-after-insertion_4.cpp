class Solution {
public:
    string maxValue(string n, int x) {
        
        string ans;
        if (n[0] == '-') {
            ans += '-';
            int i = 1;
            while (i < n.size() && n[i] - '0' <= x) {
                ans += n[i];
                ++i;
            }
            ans += (x + '0');
            while (i < n.size()) {
                ans += n[i];
                ++i;
            }
        } else {
            int i = 0;
            while (i < n.size() && n[i] - '0' >= x) {
                ans += n[i];
                ++i;
            }
            ans += (x + '0');
            while (i < n.size()) {
                ans += n[i];
                ++i;
            }
        }
        return ans;
    }
};