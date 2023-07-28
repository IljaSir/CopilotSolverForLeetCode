class Solution {
public:
    int minTimeToType(string word) {
        
        int ans = 0;
        char c = 'a';
        for (char w : word) {
            ans += min(abs(w - c), 26 - abs(w - c)) + 1;
            c = w;
        }
        return ans;
    }
};