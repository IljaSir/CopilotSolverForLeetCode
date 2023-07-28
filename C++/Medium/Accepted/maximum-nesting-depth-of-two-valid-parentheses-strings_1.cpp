class Solution {
public:
    vector<int> maxDepthAfterSplit(string seq) {
        
        int n = seq.size();
        vector<int> ans(n);
        int a = 0, b = 0;
        for (int i = 0; i < n; ++i) {
            if (seq[i] == '(') {
                if (a < b) {
                    ++a;
                } else {
                    ++b;
                    ans[i] = 1;
                }
            } else {
                if (a > b) {
                    --a;
                } else {
                    --b;
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
};