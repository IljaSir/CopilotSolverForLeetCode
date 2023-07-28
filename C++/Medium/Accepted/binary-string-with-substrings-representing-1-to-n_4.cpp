class Solution {
public:
    bool queryString(string s, int n) {
        
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            string str;
            while (tmp) {
                str += (tmp % 2) + '0';
                tmp /= 2;
            }
            reverse(str.begin(), str.end());
            if (s.find(str) == string::npos) {
                return false;
            }
        }
        return true;
    }
};