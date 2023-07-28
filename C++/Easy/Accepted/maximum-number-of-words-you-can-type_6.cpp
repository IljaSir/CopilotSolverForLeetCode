class Solution {
public:
    int canBeTypedWords(string text, string brokenLetters) {
        
        int ans = 0;
        set<char> broken(brokenLetters.begin(), brokenLetters.end());
        bool isBroken = false;
        for (auto c : text) {
            if (c == ' ') {
                if (!isBroken) {
                    ans++;
                }
                isBroken = false;
                continue;
            }
            if (broken.find(c) != broken.end()) {
                isBroken = true;
            }
        }
        if (!isBroken) {
            ans++;
        }
        return ans;
    }
};