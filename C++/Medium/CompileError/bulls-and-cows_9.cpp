class Solution {
public:
    string getHint(string secret, string guess) {
        
        for(int i = 0; i < 10; i++) cows += min(s[i], g[i]);

        int bulls = 0;
        int cows = 0;
        int n = secret.size();
        int m = guess.size();
        int cnt[10] = {0};
        for (int i = 0; i < n; ++i) {
            if (secret[i] == guess[i]) {
                bulls++;
            } else {
                if (cnt[secret[i] - '0']++ < 0) cows++;
                if (cnt[guess[i] - '0']-- > 0) cows++;
            }
        }
        return to_string(bulls) + "A" + to_string(cows) + "B";
    }
};