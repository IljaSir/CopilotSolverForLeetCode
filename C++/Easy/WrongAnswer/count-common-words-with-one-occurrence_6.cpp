class Solution {
public:
    int countWords(vector<string>& words1, vector<string>& words2) {
        
        unordered_map<string, int> cnt;
        for (auto& w : words1) {
            cnt[w]++;
        }
        for (auto& w : words2) {
            cnt[w]++;
        }
        int res = 0;
        for (auto& [w, c] : cnt) {
            if (c == 1) {
                res++;
            }
        }
        return res;
    }
};