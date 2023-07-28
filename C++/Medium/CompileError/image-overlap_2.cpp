class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = max(res, count(img1, img2, i, j));
                res = max(res, count(img2, img1, i, j));
            }
        }
        return res;
    }
};