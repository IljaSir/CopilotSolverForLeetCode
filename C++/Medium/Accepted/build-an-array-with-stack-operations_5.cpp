class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> res;
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (i == target.size()) {
                break;
            }
            res.push_back("Push");
            if (j != target[i]) {
                res.push_back("Pop");
            } else {
                i++;
            }
        }
        return res;
    }
};