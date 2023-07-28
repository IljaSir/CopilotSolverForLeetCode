class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        int ans = 0;
        int l = bottom;
        for (int i = 0; i < special.size(); ++i) {
            int r = special[i] - 1;
            if (l <= r) {
                ans = max(ans, r - l + 1);
            }
            l = special[i] + 1;
        }
        if (l <= top) {
            ans = max(ans, top - l + 1);
        }
        return ans;
    }
};