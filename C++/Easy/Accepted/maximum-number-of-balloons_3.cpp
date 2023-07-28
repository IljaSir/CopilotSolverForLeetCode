class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int a[26] = {0};
        for (auto c : text) {
            a[c-'a']++;
        }
        return min({a['b'-'a'], a['a'-'a'], a['l'-'a']/2, a['o'-'a']/2, a['n'-'a']});
    }
};