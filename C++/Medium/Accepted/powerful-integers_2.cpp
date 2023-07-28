class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        set<int> s;
        for (int i = 0; i < 20 && pow(x,i) <= bound; i++) {
            for (int j = 0; j < 20 && pow(y,j) <= bound; j++) {
                int val = pow(x,i) + pow(y,j);
                if (val <= bound) {
                    s.insert(val);
                }
            }
        }
        vector<int> res;
        for (int v: s) {
            res.push_back(v);
        }
        return res;
    }
};