class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int count[26] = {0};
        for (auto c : text) {
            count[c - 'a']++;
        }
        int ans = INT_MAX;
        ans = min(ans, count['b' - 'a']);
        ans = min(ans, count['a' - 'a']);
        ans = min(ans, count['l' - 'a'] / 2);
        ans = min(ans, count['o' - 'a'] / 2);
        ans = min(ans, count['n' - 'a']);
        return ans;
    }
};