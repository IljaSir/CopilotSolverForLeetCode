class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> score(n, 0);
        for (int i = 0; i < n; ++i) {
            score[edges[i]] += i;
        }
        int maxScore = *max_element(score.begin(), score.end());
        int maxNode = -1;
        for (int i = 0; i < n; ++i) {
            if (score[i] == maxScore) {
                if (maxNode == -1 || i < maxNode) {
                    maxNode = i;
                }
            }
        }
        return maxNode;
    }
};