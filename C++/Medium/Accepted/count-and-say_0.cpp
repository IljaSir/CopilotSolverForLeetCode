class Solution {
public:
    string countAndSay(int n) {
        
        if (n == 1) return "1";
        string s = countAndSay(n - 1);
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            int j = i;
            while (j < s.size() && s[i] == s[j]) j++;
            res += to_string(j - i) + s[i];
            i = j - 1;
        }
        return res;
    }
};