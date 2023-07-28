class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        vector<int> v;
        for (int i = 0; i < piles.size(); ++i) {
            for (int j = 0; j < piles[i].size(); ++j) {
                v.push_back(piles[i][j]);
            }
        }
        sort(v.begin(), v.end());
        int res = 0;
        for (int i = v.size() - 2; i >= 0 && k > 0; i -= 2, --k) {
            res += v[i];
        }
        return res;
    }
};