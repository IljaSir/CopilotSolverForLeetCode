class Solution {
public:
    vector<int> beautifulArray(int n) {
        
        vector<int> res(n);
        for (int i = 0; i < n; ++i) {
            res[i] = i + 1;
        }
        while (res.size() > 1) {
            vector<int> temp;
            for (int i = 0; i < res.size(); i += 2) {
                temp.push_back(res[i]);
            }
            for (int i = 1; i < res.size(); i += 2) {
                temp.push_back(res[i]);
            }
            res = temp;
        }
        return res;
    }
};