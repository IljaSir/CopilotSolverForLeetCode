class Solution {
public:
    int largestOverlap(vector<vector<int>>& img1, vector<vector<int>>& img2) {
        
        int n = img1.size();
        vector<int> A, B;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (img1[i][j] == 1)
                    A.push_back(i * 100 + j);
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (img2[i][j] == 1)
                    B.push_back(i * 100 + j);
        unordered_map<int, int> count;
        for (int a: A) for (int b: B) count[a - b]++;
        int res = 0;
        for (auto it: count) res = max(res, it.second);
        return res;
    }
};