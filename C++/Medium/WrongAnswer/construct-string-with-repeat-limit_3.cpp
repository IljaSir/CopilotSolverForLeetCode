class Solution {
public:
    string repeatLimitedString(string s, int repeatLimit) {
        
        string res = "";
        int i = 0, n = s.length();
        while(i < n) {
            int j = i;
            while(j < n && s[j] == s[i]) j++;
            int cnt = j - i;
            res += s[i];
            if(cnt > repeatLimit) {
                int k = 0;
                while(k < repeatLimit - 1) {
                    res += s[i];
                    k++;
                }
            }
            i = j;
        }
        return res;
    }
};