class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        string t = s + s;
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < i + n; j++) {
                if ((j - i) % 2 == 0 && t[j] == '1') cur++;
                if ((j - i) % 2 == 1 && t[j] == '0') cur++;
            }
            res = min(res, cur);
        }
        return res;
    }
};