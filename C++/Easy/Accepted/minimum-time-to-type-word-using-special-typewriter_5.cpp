class Solution {
public:
    int minTimeToType(string word) {
        
        int n = word.size();
        int res = n;
        char cur = 'a';
        for (int i = 0; i < n; ++i) {
            int d = abs(cur - word[i]);
            res += min(d, 26 - d);
            cur = word[i];
        }
        return res;
    }
};