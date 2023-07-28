class Solution {
public:
    int minFlips(string target) {
        
        int ans = 0;
        for (int i = 0; i < target.size(); i++) {
            if (target[i] == '1') {
                ans++;
                while (i < target.size() && target[i] == '1') {
                    i++;
                }
            }
        }
        return ans;
    }
};