class Solution {
public:
    vector<string> findRelativeRanks(vector<int>& score) {
        
        int n = score.size();
        vector<string> ranks(n);
        vector<int> sorted = score;
        sort(sorted.begin(), sorted.end(), greater<int>());
        for(int i = 0; i < n; i++) {
            if(sorted[i] == score[i]) {
                if(i == 0) {
                    ranks[i] = "Gold Medal";
                } else if(i == 1) {
                    ranks[i] = "Silver Medal";
                } else if(i == 2) {
                    ranks[i] = "Bronze Medal";
                } else {
                    ranks[i] = to_string(i + 1);
                }
            }
        }
        return ranks;
    }
};