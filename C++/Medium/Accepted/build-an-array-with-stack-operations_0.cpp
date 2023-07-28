class Solution {
public:
    vector<string> buildArray(vector<int>& target, int n) {
        
        vector<string> res;
        int i = 0;
        for (int j = 1; j <= n && i < target.size(); j++) {
            res.push_back("Push");
            if (target[i] == j) {
                i++;
            } else {
                res.push_back("Pop");
            }
        }
        return res;
    }
};