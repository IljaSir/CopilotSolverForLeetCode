class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        
        vector<vector<int>> result;
        unordered_map<int, int> win;
        unordered_map<int, int> lose;
        for (auto& m : matches) {
            win[m[0]]++;
            lose[m[1]]++;
        }
        vector<int> winers;
        vector<int> losers;
        for (auto& w : win) {
            if (lose.find(w.first) == lose.end()) {
                winers.push_back(w.first);
            }
        }
        for (auto& l : lose) {
            if (l.second == 1) {
                losers.push_back(l.first);
            }
        }
        result.push_back(winers);
        result.push_back(losers);
        return result;
    }
    vector<vector<int>> findPlayers(vector<vector<int>>& matches) {
        vector<vector<int>> result;
        unordered_map<int, int> win;
        unordered_map<int, int> lose;
        for (auto& m : matches) {
            win[m[0]]++;
            lose[m[1]]++;
        }
        vector<int> winers;
        vector<int> losers;
        for (auto& w : win) {
            if (lose.find(w.first) == lose.end()) {
                winers.push_back(w.first);
            }
        }
        for (auto& l : lose) {
            if (l.second == 1) {
                losers.push_back(l.first);
            }
        }
        result.push_back(winers);
        result.push_back(losers);
        return result;
    }
    vector<vector<int>> findPlayers2(vector<vector<int>>& matches) {
        vector<vector<int>> result;
        unordered_map<int, int> win;
        unordered_map<int, int> lose;
        for (auto& m : matches) {
            win[m[0]]++;
            lose[m[1]]++;
        }
        vector<int> winers;
        vector<int> losers;
        for (auto& w : win) {
            if (lose.find(w.first) == lose.end()) {
                winers.push_back(w.first);
            }
        }
        for (auto& l : lose) {
            if (l.second == 1) {
                losers.push_back(l.first);
            }
        }
        result.push_back(winers);
        result.push_back(losers);
        return result;
    }
};