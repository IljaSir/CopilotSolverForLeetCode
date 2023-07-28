class Solution {
public:
    int minFlips(string target) {
        
        int n = target.length();
        int ans = 0;
        char prev = '0';
        for(int i = 0; i < n; i++) {
            if(target[i] != prev) {
                ans++;
                prev = target[i];
            }
        }
        return ans;
    }
};