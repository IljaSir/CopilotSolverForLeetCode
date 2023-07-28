class Solution {
public:
    string robotWithString(string s) {
        
        string t;
        int n = s.size();
        int i = 0;
        while (i < n) {
            if (t.empty() || s[i] < t.back()) {
                t += s[i];
                ++i;
            } else {
                t.pop_back();
            }
        }
        return t;
    }
};