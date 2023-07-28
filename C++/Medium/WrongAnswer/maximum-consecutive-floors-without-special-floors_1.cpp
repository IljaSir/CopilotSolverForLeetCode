class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        int ans = 0;
        for (int i = 0; i < special.size(); ++i) {
            if (i == 0) {
                ans = max(ans, special[i] - bottom);
            }
            if (i == special.size() - 1) {
                ans = max(ans, top - special[i]);
            }
            if (i > 0) {
                ans = max(ans, special[i] - special[i - 1] - 1);
            }
        }
        return ans;
    }
};