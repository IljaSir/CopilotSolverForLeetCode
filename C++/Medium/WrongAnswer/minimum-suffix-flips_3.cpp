class Solution {
public:
    int minFlips(string target) {
        
        int n = target.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (target[i] == '1') {
                ans++;
                while (i < n && target[i] == '1') {
                    i++;
                }
                i--;
            }
        }
        return ans;
    }
};