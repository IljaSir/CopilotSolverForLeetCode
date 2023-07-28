class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        
        sort(players.begin(), players.end());
        sort(trainers.begin(), trainers.end());
        int n = players.size(), m = trainers.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (trainers[mid] >= players[i]) {
                    r = mid - 1;
                } else {
                    l = mid;
                }
            }
            if (trainers[l] >= players[i]) {
                ans++;
            }
        }
        return ans;
    }
};