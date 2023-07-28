class Solution {
public:
    vector<vector<int>> validArrangement(vector<vector<int>>& pairs) {
        
        vector<vector<int>> res;
        vector<int> temp;
        for(int i = 0; i < pairs.size(); ++i) {
            if(pairs[i][0] > pairs[i][1]) {
                swap(pairs[i][0], pairs[i][1]);
            }
        }
        sort(pairs.begin(), pairs.end(), [](vector<int>& a, vector<int>& b) {
            return a[0] < b[0];
        });
        for(int i = 0; i < pairs.size(); ++i) {
            if(temp.empty()) {
                temp.push_back(pairs[i][0]);
                temp.push_back(pairs[i][1]);
            } else {
                if(temp.back() == pairs[i][0]) {
                    temp.push_back(pairs[i][1]);
                } else {
                    res.push_back(temp);
                    temp.clear();
                    temp.push_back(pairs[i][0]);
                    temp.push_back(pairs[i][1]);
                }
            }
        }
        res.push_back(temp);
        return res;
    }
};