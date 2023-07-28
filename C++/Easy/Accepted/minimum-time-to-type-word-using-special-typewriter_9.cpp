class Solution {
public:
    int minTimeToType(string word) {
        
        int ans = 0;
        int pos = 0;
        for (char c : word) {
            int idx = c - 'a';
            ans += min(abs(idx - pos), 26 - abs(idx - pos)) + 1;
            pos = idx;
        }
        return ans;
    }
};