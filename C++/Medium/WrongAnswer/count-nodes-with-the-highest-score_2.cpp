class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<vector<int>> children(n);
        for (int i = 1; i < n; i++) {
            children[parents[i]].push_back(i);
        }
        vector<int> score(n, 1);
        vector<int> maxScore(n, 1);
        vector<int> count(n, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int child : children[i]) {
                score[i] += score[child];
                if (maxScore[child] > maxScore[i]) {
                    maxScore[i] = maxScore[child];
                    count[i] = count[child];
                } else if (maxScore[child] == maxScore[i]) {
                    count[i] += count[child];
                }
            }
            if (score[i] > maxScore[i]) {
                maxScore[i] = score[i];
                count[i] = 1;
            } else if (score[i] == maxScore[i]) {
                count[i]++;
            }
        }
        return count[0];
    }
};