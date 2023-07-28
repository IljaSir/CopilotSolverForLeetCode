class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bulls = 0;
        int cows = 0;
        unordered_map<char, int> secret_map;
        unordered_map<char, int> guess_map;
        for (int i = 0; i < secret.size(); ++i) {
            if (secret[i] == guess[i]) {
                ++bulls;
            } else {
                ++secret_map[secret[i]];
                ++guess_map[guess[i]];
            }
        }
        for (const auto& [k, v]: secret_map) {
            if (guess_map.find(k) != guess_map.end()) {
                cows += min(v, guess_map[k]);
            }
        }
        return to_string(bulls) + "A" + to_string(cows) + "B";
    }
};