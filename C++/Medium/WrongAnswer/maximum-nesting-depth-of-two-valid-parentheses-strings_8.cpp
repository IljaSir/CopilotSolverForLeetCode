class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        
        vector<int> res;
        int depth = 0;
        for (char c : seq) {
            res.push_back(depth % 2);
            if (c == '(') {
                depth++;
            } else {
                depth--;
            }
        }
        return res;
    }
};