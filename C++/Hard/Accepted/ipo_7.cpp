class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        vector<pair<int, int>> p;
        for (int i = 0; i < profits.size(); i++) {
            p.push_back({capital[i], profits[i]});
        }
        sort(p.begin(), p.end());
        priority_queue<int> q;
        int i = 0;
        while (k--) {
            while (i < p.size() && p[i].first <= w) {
                q.push(p[i].second);
                i++;
            }
            if (q.empty()) break;
            w += q.top();
            q.pop();
        }
        return w;
    }
};