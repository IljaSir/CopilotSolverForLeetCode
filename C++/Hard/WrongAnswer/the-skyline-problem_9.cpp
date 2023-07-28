class Solution {
public:
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        
        vector<vector<int>> v;
        vector<int> t;
        int i, j;
        for (i = 0; i < buildings.size(); i++) {
            t = buildings[i];
            for (j = 0; j < v.size() && v[j][0] < t[0]; j++) {
                if (v[j][1] > t[2]) {
                    t[2] = v[j][1];
                }
            }
            v.insert(v.begin() + j, t);
        }
        for (i = 0; i < v.size() - 1; i++) {
            for (j = i + 1; j < v.size(); j++) {
                if (v[j][0] > v[i][1]) {
                    break;
                }
                if (v[j][1] >= v[i][1]) {
                    v[i][1] = v[j][0];
                }
            }
        }
        for (i = 0; i < v.size(); i++) {
            v[i][1] = v[i][2];
            v[i].pop_back();
        }
        return v;
    }
};