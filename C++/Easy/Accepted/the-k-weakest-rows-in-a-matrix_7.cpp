class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        
        vector<int> result;
        vector<pair<int, int>> temp;
        for(int i = 0; i < mat.size(); i++){
            int count = 0;
            for(int j = 0; j < mat[i].size(); j++){
                if(mat[i][j] == 1)
                    count++;
            }
            temp.push_back(make_pair(count, i));
        }
        sort(temp.begin(), temp.end());
        for(int i = 0; i < k; i++){
            result.push_back(temp[i].second);
        }
        return result;
    }
};