class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        vector<int> v;
        for (auto& p: piles) {
            for (auto c: p) v.push_back(c);
        }
        sort(v.begin(), v.end());
        int n = v.size();
        int i = n - 2;
        int ans = 0;
        while (k--) {
            ans += v[i];
            i -= 2;
        }
        return ans;
    }
};