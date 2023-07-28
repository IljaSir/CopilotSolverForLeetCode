class Solution {
public:
    bool makeEqual(vector<string>& words) {
        
        int n = words.size();
        if (n == 1) return true;
        vector<int> cnt(26, 0);
        for (auto& w : words) {
            for (auto& c : w) {
                cnt[c - 'a']++;
            }
        }
        for (auto& c : cnt) {
            if (c % n != 0) return false;
        }
        return true;
    }
};