class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        
        vector<int> res;
        vector<int> visit(n, 0);
        for (int i = 1; i < rounds.size(); i++) {
            int start = rounds[i - 1];
            int end = rounds[i];
            if (start > end) {
                end += n;
            }
            for (int j = start; j < end; j++) {
                visit[j % n]++;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (visit[i] > max) {
                max = visit[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (visit[i] == max) {
                res.push_back(i + 1);
            }
        }
        return res;
    }
};