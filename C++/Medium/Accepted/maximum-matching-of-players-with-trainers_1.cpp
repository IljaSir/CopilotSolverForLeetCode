class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        
        sort(players.begin(), players.end());
        sort(trainers.begin(), trainers.end());
        int res = 0;
        for (int i = 0, j = 0; i < players.size(); ++i) {
            while (j < trainers.size() && players[i] > trainers[j]) ++j;
            if (j < trainers.size()) {
                ++res;
                ++j;
            }
        }
        return res;
    }
};