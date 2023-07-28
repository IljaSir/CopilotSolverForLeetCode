class Solution {
public:
    int minTimeToType(string word) {
        
        int ans = 0;
        char cur = 'a';
        for (auto c : word) {
            ans += min(abs(c - cur), 26 - abs(c - cur));
            ans++;
            cur = c;
        }
        return ans;
    }
};