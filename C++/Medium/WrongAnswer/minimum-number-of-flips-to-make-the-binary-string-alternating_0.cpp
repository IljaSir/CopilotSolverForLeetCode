class Solution {
public:
    int minFlips(string s) {
        
        int n = s.size();
        s += s;
        int res = INT_MAX;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < i + n; j++) {
                if (j % 2 == 0 && s[j] != '0') cnt++;
                if (j % 2 == 1 && s[j] != '1') cnt++;
            }
            res = min(res, cnt);
        }
        return res;
    }
};