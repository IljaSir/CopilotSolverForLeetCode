class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.length();
        string a = s.substr(0, n/2);
        string b = s.substr(n/2, n/2);
        int cnt = 0;
        for (char c: a) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                cnt++;
            }
        }
        for (char c: b) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                cnt--;
            }
        }
        return cnt == 0;
    }
};