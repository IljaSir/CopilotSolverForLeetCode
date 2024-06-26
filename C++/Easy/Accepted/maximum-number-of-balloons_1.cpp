class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int count[26] = {0};
        for (char c : text) {
            count[c - 'a']++;
        }
        int res = INT_MAX;
        res = min(res, count['b' - 'a']);
        res = min(res, count['a' - 'a']);
        res = min(res, count['l' - 'a'] / 2);
        res = min(res, count['o' - 'a'] / 2);
        res = min(res, count['n' - 'a']);
        return res;
    }
};