class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        int n = profits.size();
        vector<pair<int, int>> p(n);
        for (int i = 0; i < n; ++i) {
            p[i] = {capital[i], profits[i]};
        }
        sort(p.begin(), p.end());
        priority_queue<int> q;
        int i = 0;
        while (i < n && p[i].first <= w) {
            q.push(p[i].second);
            ++i;
        }
        while (k--) {
            if (q.empty()) {
                break;
            }
            w += q.top();
            q.pop();
            while (i < n && p[i].first <= w) {
                q.push(p[i].second);
                ++i;
            }
        }
        return w;
    }
};