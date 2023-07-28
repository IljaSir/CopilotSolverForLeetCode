class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bull = 0, cow = 0;
        unordered_map<char, int> m;
        for (int i = 0; i < secret.size(); ++i) {
            if (secret[i] == guess[i]) {
                bull++;
            } else {
                if (m[secret[i]]++ < 0) cow++;
                if (m[guess[i]]-- > 0) cow++;
            }
        }
        return to_string(bull) + "A" + to_string(cow) + "B";
    }
};