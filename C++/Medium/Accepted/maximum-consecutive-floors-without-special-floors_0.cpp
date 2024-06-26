class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        sort(special.begin(), special.end());
        int ans = 0;
        int n = special.size();
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                ans = max(ans, special[i] - bottom);
            } else {
                ans = max(ans, special[i] - special[i - 1] - 1);
            }
        }
        if (n > 0) {
            ans = max(ans, top - special[n - 1]);
        } else {
            ans = top - bottom + 1;
        }
        return ans;
    }
};