class Solution {
public:
    string robotWithString(string s) {
        
        string r;
        int i = 0, j = s.size() - 1;
        while (i <= j) {
            bool left = false;
            for (int k = 0; i + k <= j; ++k) {
                if (s[i + k] < s[j - k]) {
                    left = true;
                    break;
                } else if (s[i + k] > s[j - k]) {
                    left = false;
                    break;
                }
            }
            if (left) r.push_back(s[i++]);
            else r.push_back(s[j--]);
        }
        return r;
    }
};