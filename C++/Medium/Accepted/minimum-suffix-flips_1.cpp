class Solution {
public:
    int minFlips(string target) {
        
        int ans = 0;
        char cur = '0';
        for (auto c : target) {
            if (c != cur) {
                ans++;
                cur = c;
            }
        }
        return ans;
    }
};