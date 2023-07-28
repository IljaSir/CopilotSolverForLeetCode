class Solution {
public:
    vector<int> beautifulArray(int n) {
        
        vector<int> res;
        res.push_back(1);
        while (res.size() < n) {
            vector<int> tmp;
            for (int i = 0; i < res.size(); ++i) {
                if (res[i] * 2 - 1 <= n) {
                    tmp.push_back(res[i] * 2 - 1);
                }
            }
            for (int i = 0; i < res.size(); ++i) {
                if (res[i] * 2 <= n) {
                    tmp.push_back(res[i] * 2);
                }
            }
            res = tmp;
        }
        return res;
    }
};