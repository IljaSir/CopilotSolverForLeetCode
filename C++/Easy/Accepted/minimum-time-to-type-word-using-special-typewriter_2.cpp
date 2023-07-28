class Solution {
public:
    int minTimeToType(string word) {
        
        int ans = word.size();
        char cur = 'a';
        for (auto c : word) {
            int diff = abs(c - cur);
            ans += min(diff, 26 - diff);
            cur = c;
        }
        return ans;
    }
};