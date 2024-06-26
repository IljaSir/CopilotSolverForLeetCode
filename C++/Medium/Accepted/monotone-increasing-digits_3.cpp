class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        
        string s = to_string(n);
        int p = s.size();
        for (int i = s.size() - 1; i > 0; i--) {
            if (s[i] < s[i - 1]) {
                p = i;
                s[i - 1]--;
            }
        }
        for (int i = p; i < s.size(); i++) {
            s[i] = '9';
        }
        return stoi(s);
    }
};