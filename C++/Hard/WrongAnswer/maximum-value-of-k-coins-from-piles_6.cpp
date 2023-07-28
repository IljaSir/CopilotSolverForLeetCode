class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        vector<int> v;
        for (auto& p : piles) {
            sort(p.begin(), p.end(), greater<int>());
            for (int i = 1; i < p.size(); i += 2)
                v.push_back(p[i]);
        }
        sort(v.begin(), v.end(), greater<int>());
        int res = 0;
        for (int i = 0; i < k; ++i)
            res += v[i];
        return res;
    }
};