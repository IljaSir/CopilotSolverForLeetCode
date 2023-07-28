class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        int cnt[26] = {0};
        for (int i = 0; i < n; i++) {
            for (auto c : words[i]) {
                cnt[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % n != 0) return false;
        }
        return true;
    }
};