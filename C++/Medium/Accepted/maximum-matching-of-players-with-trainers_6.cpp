class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        
        sort(players.rbegin(), players.rend());
        sort(trainers.rbegin(), trainers.rend());
        int i = 0, j = 0, res = 0;
        while (i < players.size() && j < trainers.size()) {
            if (players[i] <= trainers[j]) {
                ++i;
                ++j;
                ++res;
            } else {
                ++i;
            }
        }
        return res;
    }
};