class Solution {
public:
    string shortestCompletingWord(string licensePlate, vector<string>& words) {
        
        vector<int> c(26, 0);
        for (auto ch: licensePlate) {
            if (isalpha(ch)) {
                c[tolower(ch) - 'a']++;
            }
        }
        string ans;
        for (auto word: words) {
            vector<int> cc(c);
            for (auto ch: word) {
                cc[ch - 'a']--;
            }
            bool ok = true;
            for (auto x: cc) {
                if (x > 0) {
                    ok = false;
                    break;
                }
            }
            if (ok && (ans.empty() || word.size() < ans.size())) {
                ans = word;
            }
        }
        return ans;
    }
};