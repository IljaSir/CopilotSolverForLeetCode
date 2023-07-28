class Solution {
public:
    string robotWithString(string s) {
        
        int n = s.length();
        string t = "";
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            bool left = false;
            for (int k = 0; i + k <= j; k++) {
                if (s[i + k] < s[j - k]) {
                    left = true;
                    break;
                } else if (s[i + k] > s[j - k]) {
                    left = false;
                    break;
                }
            }
            if (left) {
                t += s[i++];
            } else {
                t += s[j--];
            }
        }
        return t;
    }
};