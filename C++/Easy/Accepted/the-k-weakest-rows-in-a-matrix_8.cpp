class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        vector<int> res;
        vector<int> cnt(mat.size(), 0);
        for(int i=0; i<mat.size(); i++)
            for(int j=0; j<mat[i].size(); j++)
                cnt[i] += mat[i][j];
        vector<int> tmp = cnt;
        sort(tmp.begin(), tmp.end());
        for(int i=0; i<k; i++)
            for(int j=0; j<mat.size(); j++)
                if(cnt[j] == tmp[i]){
                    res.push_back(j);
                    cnt[j] = INT_MAX;
                    break;
                }
        return res;
    }
};