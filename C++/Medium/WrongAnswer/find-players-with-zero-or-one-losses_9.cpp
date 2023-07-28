class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        vector<vector<int>> result;
        vector<int> winners;
        vector<int> losers;
        unordered_map<int, int> players;
        for (auto& match : matches) {
            players[match[0]]++;
            players[match[1]]--;
        }
        for (auto& player : players) {
            if (player.second > 0) {
                winners.push_back(player.first);
            } else if (player.second == 0) {
                losers.push_back(player.first);
            }
        }
        sort(winners.begin(), winners.end());
        sort(losers.begin(), losers.end());
        result.push_back(winners);
        result.push_back(losers);
        return result;
    }
};