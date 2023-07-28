class Solution {
public:
    string robotWithString(string s) {
        
        string t;
        int n = s.size();
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            bool left = false;
            for (int k = 0; i + k <= j; k++) {
                if (s[i + k] < s[j - k]) {
                    left = true;
                    break;
                }
                if (s[i + k] > s[j - k]) {
                    left = false;
                    break;
                }
            }
            if (left) {
                t.push_back(s[i++]);
            } else {
                t.push_back(s[j--]);
            }
        }
        return t;
    }
};