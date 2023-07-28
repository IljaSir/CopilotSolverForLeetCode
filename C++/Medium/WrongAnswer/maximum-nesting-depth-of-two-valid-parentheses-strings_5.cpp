class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        
        vector<int> res;
        int depth = 0;
        for (char c : seq) {
            depth += c == '(' ? 1 : -1;
            res.push_back(depth % 2);
        }
        return res;
    }
};