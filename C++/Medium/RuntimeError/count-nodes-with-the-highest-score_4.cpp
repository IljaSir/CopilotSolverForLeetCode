class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> tree[n];
        int root = 0;
        for(int i = 0; i < n; i++) {
            if(parents[i] == -1) {
                root = i;
                continue;
            }
            tree[parents[i]].push_back(i);
        }
        vector<int> size(n, 1);
        vector<int> score(n, 1);
        vector<int> maxScore(n, 1);
        vector<int> maxScoreNodes(n, 0);
        for(int i = n - 1; i >= 0; i--) {
            for(int child : tree[i]) {
                size[i] += size[child];
                score[i] *= size[child];
            }
            if(score[i] > maxScore[parents[i]]) {
                maxScore[parents[i]] = score[i];
                maxScoreNodes[parents[i]] = 1;
            } else if(score[i] == maxScore[parents[i]]) {
                maxScoreNodes[parents[i]]++;
            }
        }
        return maxScoreNodes[root];
    }
};