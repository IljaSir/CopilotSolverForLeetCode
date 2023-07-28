class Solution {
public:
    int minTimeToType(string word) {
        
        int n = word.size();
        int res = 0;
        char cur = 'a';
        for (int i = 0; i < n; i++) {
            int diff = abs(cur - word[i]);
            res += min(diff, 26 - diff);
            cur = word[i];
            res++;
        }
        return res;
    }
};