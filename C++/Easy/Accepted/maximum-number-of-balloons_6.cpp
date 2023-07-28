class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int a[26] = {0};
        for (auto c : text) {
            a[c - 'a']++;
        }
        int res = 100000;
        res = min(res, a['b' - 'a']);
        res = min(res, a['a' - 'a']);
        res = min(res, a['l' - 'a'] / 2);
        res = min(res, a['o' - 'a'] / 2);
        res = min(res, a['n' - 'a']);
        return res;
    }
};