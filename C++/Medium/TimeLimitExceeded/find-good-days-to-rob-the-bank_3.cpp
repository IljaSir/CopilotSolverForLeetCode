class Solution {
public:
    vector<int> goodDaysToRobBank(vector<int>& security, int time) {
        
        vector<int> result;
        int n = security.size();
        for (int i = time; i < n - time; ++i) {
            bool good = true;
            for (int j = 1; j <= time; ++j) {
                if (security[i - j] < security[i - j + 1]) {
                    good = false;
                    break;
                }
            }
            if (good) {
                for (int j = 1; j <= time; ++j) {
                    if (security[i + j] < security[i + j - 1]) {
                        good = false;
                        break;
                    }
                }
            }
            if (good) {
                result.push_back(i);
            }
        }
        return result;
    }
};