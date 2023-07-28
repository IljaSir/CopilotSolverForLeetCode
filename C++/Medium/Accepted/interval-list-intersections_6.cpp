class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        
        int i=0, j=0;
        vector<vector<int>> res;
        while(i<firstList.size() && j<secondList.size()) {
            vector<int> f = firstList[i];
            vector<int> s = secondList[j];
            if(f[0] <= s[1] && s[0] <= f[1]) {
                res.push_back({max(f[0], s[0]), min(f[1], s[1])});
            }
            if(f[1] < s[1]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
};