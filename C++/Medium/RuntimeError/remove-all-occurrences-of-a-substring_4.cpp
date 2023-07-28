class Solution {
public:
    string removeOccurrences(string s, string part) {
        
        int n = s.size();
        int m = part.size();
        int i = 0;
        while (i <= n - m) {
            if (s.substr(i, m) == part) {
                s.erase(i, m);
                i = 0;
            } else {
                i++;
            }
        }
        return s;
    }
};