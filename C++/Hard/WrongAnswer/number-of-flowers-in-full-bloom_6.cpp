class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        int n = flowers.size();
        int m = people.size();
        vector<int> res(m, 0);
        int f = 0;
        int p = 0;
        set<vector<int>> s;
        while (p < m) {
            while (f < n && flowers[f][0] <= people[p]) {
                s.insert({flowers[f][1], f});
                ++f;
            }
            while (!s.empty() && s.begin()->at(0) <= people[p]) {
                ++res[p];
                s.erase(s.begin());
            }
            ++p;
        }
        return res;
    }
};