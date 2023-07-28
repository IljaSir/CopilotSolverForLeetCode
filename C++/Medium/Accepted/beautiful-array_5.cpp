class Solution {
public:
    vector<int> beautifulArray(int n) {
        
        vector<int> res;
        res.push_back(1);
        while (res.size() < n) {
            vector<int> tmp;
            for (int x : res) {
                if (2 * x - 1 <= n) {
                    tmp.push_back(2 * x - 1);
                }
            }
            for (int x : res) {
                if (2 * x <= n) {
                    tmp.push_back(2 * x);
                }
            }
            res = tmp;
        }
        return res;
    }
};