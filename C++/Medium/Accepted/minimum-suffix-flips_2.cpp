class Solution {
public:
    int minFlips(string target) {
        
        int n = target.size();
        int ans = 0;
        char cur = '0';
        for (int i = 0; i < n; i++) {
            if (cur != target[i]) {
                ans++;
                cur = target[i];
            }
        }
        return ans;
    }
};