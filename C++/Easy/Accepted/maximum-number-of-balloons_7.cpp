class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int a[26] = {0};
        for (auto t : text) a[t - 'a']++;
        int ans = INT_MAX;
        ans = min(ans, a['b' - 'a']);
        ans = min(ans, a['a' - 'a']);
        ans = min(ans, a['l' - 'a'] / 2);
        ans = min(ans, a['o' - 'a'] / 2);
        ans = min(ans, a['n' - 'a']);
        return ans;
    }
};