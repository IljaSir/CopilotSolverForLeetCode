class Solution {
public:
    bool isPrintable(vector<vector<int>>& targetGrid) {
        
        int m = targetGrid.size();
        int n = targetGrid[0].size();
        vector<int> minr(61, m);
        vector<int> maxr(61, 0);
        vector<int> minc(61, n);
        vector<int> maxc(61, 0);
        vector<int> area(61, 0);
        vector<int> color(61, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                minr[c] = min(minr[c], i);
                maxr[c] = max(maxr[c], i);
                minc[c] = min(minc[c], j);
                maxc[c] = max(maxc[c], j);
                area[c]++;
                color[c] = c;
            }
        }
        for (int i = 1; i <= 60; i++) {
            for (int j = i + 1; j <= 60; j++) {
                if (area[i] == 0 || area[j] == 0) continue;
                if (minr[i] >= minr[j] && maxr[i] <= maxr[j] && minc[i] >= minc[j] && maxc[i] <= maxc[j]) {
                    area[j] = 0;
                }
                if (minr[i] <= minr[j] && maxr[i] >= maxr[j] && minc[i] <= minc[j] && maxc[i] >= maxc[j]) {
                    area[i] = 0;
                }
            }
        }
        vector<int> p(61, 0);
        for (int i = 1; i <= 60; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= 60; i++) {
            if (area[i] == 0) continue;
            for (int j = i + 1; j <= 60; j++) {
                if (area[j] == 0) continue;
                if (minr[i] >= minr[j] && maxr[i] <= maxr[j] && minc[i] >= minc[j] && maxc[i] <= maxc[j
    }
};