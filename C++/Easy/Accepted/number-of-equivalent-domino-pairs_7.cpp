class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        
        int n = dominoes.size();
        vector<int> cnt(100);
        for (auto& d : dominoes) {
            int x = d[0], y = d[1];
            if (x > y) swap(x, y);
            ++cnt[x * 10 + y];
        }
        int ans = 0;
        for (int c : cnt) {
            ans += c * (c - 1) / 2;
        }
        return ans;
    }
};