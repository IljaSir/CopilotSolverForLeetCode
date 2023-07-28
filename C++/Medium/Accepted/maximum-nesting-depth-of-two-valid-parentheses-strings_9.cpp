class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        
        vector<int> ans;
        int d = 0;
        for (auto c: seq) {
            if (c == '(') {
                ans.push_back(d);
                d = 1 - d;
            } else {
                d = 1 - d;
                ans.push_back(d);
            }
        }
        return ans;
    }
};