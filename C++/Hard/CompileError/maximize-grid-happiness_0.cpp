class Solution {
public:
    int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int result = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int intro = (i == 0) ? 0 : 1;
                int extro = (j == 0) ? 0 : 1;
                int happiness = 120 + 20 * intro + 20 * extro - 30 * intro - 30 * extro;
                result = max(result, happiness + getMaxGridHappiness(m, n, i, j, introvertsCount - 1, extrovertsCount));
            }
        }
        return result;
    }
    
    int getMaxGridHappiness(int m, int n, int i, int j, int introvertsCount, int extrovertsCount) {
        if (introvertsCount < 0 || extrovertsCount < 0) {
            return 0;
        }
        int result = 0;
        for (int k = i; k < m; ++k) {
            for (int l = (k == i) ? j + 1 : 0; l < n; ++l) {
                int intro = (k == 0) ? 0 : 1;
                int extro = (l == 0) ? 0 : 1;
                int happiness = 120 + 20 * intro + 20 * extro - 30 * intro - 30 * extro;
                result = max(result, happiness + getMaxGridHappiness(m, n, k, l, introvertsCount - 1, extrovertsCount));
            }
        }
        return result;
    }
    
    int getMaxGridHappiness(int m, int n, int i, int j, int introvertsCount, int extrovertsCount) {
        if (introvertsCount < 0 || extrovertsCount < 0) {
            return 0;
        }
        int result = 0;
        for (int k = i; k < m; ++k) {
            for (int l = (k == i) ? j + 1 : 0; l < n; ++l) {
                int intro = (k == 0) ? 0 : 1;
                int extro = (l == 0) ?
    }
};