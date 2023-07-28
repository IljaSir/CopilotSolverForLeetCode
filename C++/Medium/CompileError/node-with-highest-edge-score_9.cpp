class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int maxScore = 0;
        int maxScoreNode = 0;
        for (int i = 0; i < edges.size(); i++) {
            int score = 0;
            for (int j = 0; j < edges.size(); j++) {
                if (edges[j] == i) {
                    score += j;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                maxScoreNode = i;
            }
        }
        return maxScoreNode;
    }
    int findCenter(vector<vector<int>>& edges) {
        vector<int> node(edges.size() + 1, 0);
        for (auto& edge : edges) {
            node[edge[0]]++;
            node[edge[1]]++;
        }
        int maxNode = 0;
        int maxCount = 0;
        for (int i = 0; i < node.size(); i++) {
            if (node[i] > maxCount) {
                maxCount = node[i];
                maxNode = i;
            }
        }
        return maxNode;
    }
    int getNodeWithHighestEdgeScore(vector<int>& edges) {
        vector<int> node(edges.size() + 1, 0);
        for (int i = 0; i < edges.size(); i++) {
            node[i] = edges[i];
        }
        return edgeScore(node);
    }
    int getNodeWithHighestEdgeScore2(vector<int>& edges) {
        int maxScore = 0;
        int maxScoreNode = 0;
        for (int i = 0; i < edges.size(); i++) {
            int score = 0;
            for (int j = 0; j < edges.size(); j++) {
                if (edges[j] == i) {
                    score += j;
                }
            }
            if (score > maxScore) {
                maxScore = score;
                maxScoreNode = i;
            }
        }
        return maxScoreNode;
    }
    int getNodeWithHighestEdgeScore3(vector<int>& edges) {
        vector<int> node(edges.size() + 1, 0);
        for (int i = 0; i < edges.size(); i++) {
            node[edges[i]] += i;
        }
        int maxScore = 0;
        int maxScoreNode = 0;
        for (int i =
    }
};