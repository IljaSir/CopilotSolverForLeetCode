class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> score(n,0);
        for(int i=0; i<n; i++) {
            score[edges[i]]++;
        }
        int maxScore = 0;
        int maxNode = 0;
        for(int i=0; i<n; i++) {
            if(score[i] > maxScore) {
                maxScore = score[i];
                maxNode = i;
            }
        }
        return maxNode;
    }
};