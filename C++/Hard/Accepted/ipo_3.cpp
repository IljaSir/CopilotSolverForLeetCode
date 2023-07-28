class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        int n = profits.size();
        vector<pair<int, int>> v;
        for (int i = 0; i < n; ++i) {
            v.emplace_back(capital[i], profits[i]);
        }
        sort(v.begin(), v.end());
        priority_queue<int> pq;
        for (int i = 0, j = 0; i < k; ++i) {
            for (; j < n && v[j].first <= w; ++j) {
                pq.push(v[j].second);
            }
            if (pq.empty()) {
                break;
            }
            w += pq.top();
            pq.pop();
        }
        return w;
    }
};