class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> child(n, 0);
        vector<int> score(n, 0);
        for (int i = 1; i < n; ++i) {
            child[parents[i]]++;
        }
        queue<int> q;
        for (int i = 0; i < n; ++i) {
            if (child[i] == 0) {
                q.push(i);
            }
        }
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            if (parents[cur] != -1) {
                score[parents[cur]] = max(score[parents[cur]], ++score[cur]);
                if (--child[parents[cur]] == 0) {
                    q.push(parents[cur]);
                }
            }
        }
        int maxScore = 0;
        for (int i = 0; i < n; ++i) {
            maxScore = max(maxScore, score[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (score[i] == maxScore) {
                ans++;
            }
        }
        return ans;
    }
};