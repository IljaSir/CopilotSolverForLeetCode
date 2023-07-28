class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; ++i) {
            children[parents[i]].push_back(i);
        }
        vector<int> size(n, 1);
        for (int i = n - 1; i >= 0; --i) {
            for (int child : children[i]) {
                size[i] += size[child];
            }
        }
        vector<int> score(n, 1);
        for (int i = n - 1; i >= 0; --i) {
            for (int child : children[i]) {
                score[i] *= size[child] + 1;
            }
        }
        int max_score = 0;
        for (int i = 0; i < n; ++i) {
            max_score = max(max_score, score[i]);
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (score[i] == max_score) {
                ++result;
            }
        }
        return result;
    }
};