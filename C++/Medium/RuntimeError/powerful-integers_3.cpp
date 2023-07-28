class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vector<int> ans;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                int val = pow(x, i) + pow(y, j);
                if (val <= bound) {
                    ans.push_back(val);
                }
            }
        }
        sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return ans;
    }
};