class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> ans(2, 0);
        int x = min(a, min(b, c));
        int z = max(a, max(b, c));
        int y = a + b + c - x - z;
        if (y - x == 1 && z - y == 1) {
            return ans;
        }
        if (y - x <= 2 || z - y <= 2) {
            ans[0] = 1;
        } else {
            ans[0] = 2;
        }
        ans[1] = y - x - 1 + z - y - 1;
        return ans;
    }
};