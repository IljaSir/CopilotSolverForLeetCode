class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        // priority_queue<int> pq;
        // for (int i = 0; i < k; ++i) {
        //     for (int j = 0; j < profits.size(); ++j) {
        //         if (capital[j] <= w) {
        //             pq.push(profits[j]);
        //             capital[j] = INT_MAX;
        //         }
        //     }
        //     if (pq.empty()) return w;
        //     w += pq.top();
        //     pq.pop();
        // }
        // return w;
        priority_queue<int> pq;
        vector<pair<int, int>> v;
        for (int i = 0; i < profits.size(); ++i) {
            v.push_back({capital[i], profits[i]});
        }
        sort(v.begin(), v.end());
        int i = 0;
        for (int j = 0; j < k; ++j) {
            while (i < v.size() && v[i].first <= w) {
                pq.push(v[i].second);
                ++i;
            }
            if (pq.empty()) return w;
            w += pq.top();
            pq.pop();
        }
        return w;
    }
};