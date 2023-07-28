class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> children(n);
        vector<int> nodes(n);
        vector<int> scores(n);
        vector<int> subscores(n);
        for (int i = 0; i < n; ++i) {
            if (parents[i] != -1) {
                ++children[parents[i]];
            }
        }
        int root = 0;
        for (int i = 0; i < n; ++i) {
            if (children[i] == 0) {
                nodes[i] = 1;
                scores[i] = 1;
                subscores[i] = 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (children[i] > 0) {
                root = i;
                break;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (children[i] == 0) {
                int node = i;
                while (node >= 0) {
                    ++nodes[node];
                    scores[node] *= subscores[node];
                    subscores[node] = 1;
                    if (children[node] == 1) {
                        node = parents[node];
                    } else {
                        break;
                    }
                }
            }
        }
        int maxScore = 0;
        for (int i = 0; i < n; ++i) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (scores[i] == maxScore) {
                ++count;
            }
        }
        return count;
    }
};