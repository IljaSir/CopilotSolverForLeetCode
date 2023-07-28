class Solution {
public:
    int minTimeToType(string word) {
        
        int ans = 0;
        char prev = 'a';
        for (char c : word) {
            int diff = abs(c - prev);
            ans += min(diff, 26 - diff) + 1;
            prev = c;
        }
        return ans;
    }
};