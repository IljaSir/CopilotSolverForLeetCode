class Solution {
public:
    vector<int> fullBloomFlowers(vector<vector<int>>& flowers, vector<int>& people) {
        
        vector<int> res;
        int n = people.size();
        int m = flowers.size();
        sort(flowers.begin(), flowers.end(), [](auto& a, auto& b) {
            return a[0] < b[0];
        });
        for (int i = 0; i < n; ++i) {
            int cnt = 0;
            for (int j = 0; j < m; ++j) {
                if (people[i] > flowers[j][1]) continue;
                if (people[i] >= flowers[j][0]) ++cnt;
            }
            res.push_back(cnt);
        }
        return res;
    }
};