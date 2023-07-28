class Solution {
public:
    string robotWithString(string s) {
        
        string t = "";
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            bool left = false;
            for (int k = 0; i + k <= j; k++) {
                if (s[i+k] < s[j-k]) {
                    left = true;
                    break;
                } else if (s[i+k] > s[j-k]) {
                    left = false;
                    break;
                }
            }
            if (left) {
                t.push_back(s[i]);
                i++;
            } else {
                t.push_back(s[j]);
                j--;
            }
        }
        return t;
    }
};