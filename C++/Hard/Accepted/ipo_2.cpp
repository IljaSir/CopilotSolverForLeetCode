class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        
        vector<pair<int, int>> projects;
        for (int i = 0; i < profits.size(); ++i) {
            projects.emplace_back(capital[i], profits[i]);
        }
        sort(projects.begin(), projects.end());
        priority_queue<int> pq;
        int j = 0;
        for (int i = 0; i < k; ++i) {
            while (j < projects.size() && projects[j].first <= w) {
                pq.push(projects[j].second);
                ++j;
            }
            if (!pq.empty()) {
                w += pq.top();
                pq.pop();
            }
        }
        return w;
    }
};