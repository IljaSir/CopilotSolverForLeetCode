class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vector<int> ans;
        set<int> s;
        for (int i = 0; i <= 19; i++) {
            for (int j = 0; j <= 19; j++) {
                int tmp = pow(x, i) + pow(y, j);
                if (tmp <= bound && s.find(tmp) == s.end()) {
                    ans.push_back(tmp);
                    s.insert(tmp);
                }
            }
        }
        return ans;
    }
};