class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> score(n, 0);
        for (int i = 0; i < n; i++) {
            score[edges[i]]++;
        }
        int max_score = 0;
        int max_index = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] > max_score) {
                max_score = score[i];
                max_index = i;
            }
        }
        return max_index;
    }
};