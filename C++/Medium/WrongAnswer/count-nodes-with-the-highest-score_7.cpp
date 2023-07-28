class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> cnt(n);
        vector<int> score(n);
        for (int i = n - 1; i >= 0; --i) {
            if (score[i] == 0) score[i] = 1;
            if (parents[i] == -1) continue;
            int p = parents[i];
            if (score[p] == 0) score[p] = 1;
            score[p] *= (cnt[i] + 1);
            cnt[p] += (cnt[i] + 1);
        }
        int max_score = *max_element(score.begin(), score.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (score[i] == max_score) ++ans;
        }
        return ans;
    }
};