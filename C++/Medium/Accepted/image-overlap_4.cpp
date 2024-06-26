class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        int ans = 0;
        vector<int> v1, v2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j]) v1.push_back(i * 100 + j);
                if (img2[i][j]) v2.push_back(i * 100 + j);
            }
        }
        unordered_map<int, int> m;
        for (int i : v1) {
            for (int j : v2) {
                m[i - j]++;
            }
        }
        for (auto it : m) {
            ans = max(ans, it.second);
        }
        return ans;
    }
};