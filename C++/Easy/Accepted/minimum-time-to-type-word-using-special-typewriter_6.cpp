class Solution {
public:
    int minTimeToType(string word) {
        
        int n = word.size();
        int res = 0;
        char cur = 'a';
        for (int i = 0; i < n; i++) {
            int d = abs(word[i] - cur);
            res += min(d, 26 - d) + 1;
            cur = word[i];
        }
        return res;
    }
};