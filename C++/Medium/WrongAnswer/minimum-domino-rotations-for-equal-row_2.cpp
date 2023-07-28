class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        vector<int> count(7, 0);
        for (int i = 0; i < n; ++i) {
            ++count[tops[i]];
            if (tops[i] != bottoms[i]) ++count[bottoms[i]];
        }
        int ans = INT_MAX;
        for (int i = 1; i <= 6; ++i) {
            if (count[i] < n) continue;
            int a = 0, b = 0;
            for (int j = 0; j < n; ++j) {
                if (tops[j] != i && bottoms[j] != i) break;
                if (tops[j] == i) ++a;
                if (bottoms[j] == i) ++b;
                if (j == n - 1) ans = min(ans, min(a, b));
            }
        }
        return ans == INT_MAX ? -1 : ans;
    }
};