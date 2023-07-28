class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        vector<int> cnt(26, 0);
        for (auto& word: words) {
            for (auto& c: word) {
                cnt[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
};