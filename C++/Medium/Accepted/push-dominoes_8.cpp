class Solution {
public:
    string pushDominoes(string dominoes) {
        
        int n = dominoes.size();
        vector<int> dist(n, 0);
        int d = 0;
        for (int i = 0; i < n; ++i) {
            if (dominoes[i] == 'R') d = n;
            else if (dominoes[i] == 'L') d = 0;
            else d = max(d - 1, 0);
            dist[i] += d;
        }
        d = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (dominoes[i] == 'L') d = n;
            else if (dominoes[i] == 'R') d = 0;
            else d = max(d - 1, 0);
            dist[i] -= d;
        }
        string ans;
        for (int i = 0; i < n; ++i) {
            if (dist[i] > 0) ans += 'R';
            else if (dist[i] < 0) ans += 'L';
            else ans += '.';
        }
        return ans;
    }
};