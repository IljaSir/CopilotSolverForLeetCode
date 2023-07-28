class Solution {
public:
    string getHappyString(int n, int k) {
        
        string s = "";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            s += 'a';
        }
        while (true) {
            if (isHappy(s)) {
                cnt++;
                if (cnt == k) {
                    return s;
                }
            }
            if (!next_permutation(s.begin(), s.end())) {
                return "";
            }
        }
    }
    bool isHappy(string s) {
        for (int i = 1; i < s.length(); i++) {
            if (s[i] == s[i - 1]) {
                return false;
            }
        }
        return true;
    }
};