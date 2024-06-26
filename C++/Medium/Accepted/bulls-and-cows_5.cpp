class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bull = 0;
        int cow = 0;
        int n = secret.size();
        int s[10] = {0};
        int g[10] = {0};
        for (int i = 0; i < n; ++i) {
            if (secret[i] == guess[i]) {
                ++bull;
            } else {
                ++s[secret[i] - '0'];
                ++g[guess[i] - '0'];
            }
        }
        for (int i = 0; i < 10; ++i) {
            cow += min(s[i], g[i]);
        }
        return to_string(bull) + "A" + to_string(cow) + "B";
    }
};