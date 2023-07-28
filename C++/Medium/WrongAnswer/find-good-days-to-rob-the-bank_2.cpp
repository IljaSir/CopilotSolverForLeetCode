class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        int n = security.size();
        vector<int> res;
        for (int i = time; i < n - time; ++i) {
            bool ok = true;
            for (int j = i - time; j < i; ++j) {
                if (security[j] > security[j + 1]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                for (int j = i + time; j > i; --j) {
                    if (security[j - 1] < security[j]) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                res.push_back(i);
            }
        }
        return res;
    }
};