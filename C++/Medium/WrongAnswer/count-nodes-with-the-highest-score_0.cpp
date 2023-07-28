class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        int root = 0;
        for (int i = 0; i < n; ++i) {
            if (parents[i] == -1) {
                root = i;
                break;
            }
        }
        vector<int> children(n, 0);
        for (int i = 0; i < n; ++i) {
            if (i != root) {
                ++children[parents[i]];
            }
        }
        vector<int> score(n, 1);
        for (int i = 0; i < n; ++i) {
            if (i != root && children[i] == 0) {
                int j = i;
                while (j != root) {
                    ++score[j];
                    j = parents[j];
                }
                ++score[j];
            }
        }
        int maxScore = 0;
        for (int i = 0; i < n; ++i) {
            maxScore = max(maxScore, score[i]);
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (score[i] == maxScore) {
                ++count;
            }
        }
        return count;
    }
};