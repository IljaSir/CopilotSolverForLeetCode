class Solution {
public:
    int countHighestScoreNodes(vector<int>& parents) {
        
        int n = parents.size();
        vector<int> score(n, 1);
        vector<int> count(n, 0);
        int maxScore = 1;
        for(int i = n - 1; i > 0; i--) {
            int p = parents[i];
            score[p] *= score[i] + 1;
            maxScore = max(maxScore, score[p]);
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(score[i] == maxScore) {
                res++;
            }
        }
        return res;
    }
};