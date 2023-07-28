class Solution {
public:
    vector<string> simplifiedFractions(int n) {
        
        vector<string> res;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int a = i, b = j;
                while (b != 0) {
                    int t = b;
                    b = a % b;
                    a = t;
                }
                if (a == 1) {
                    res.push_back(to_string(i) + "/" + to_string(j));
                }
            }
        }
        return res;
    }
};