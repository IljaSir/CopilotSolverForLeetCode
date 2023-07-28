class Solution {
public:
    int maximumTop(vector<int>& nums, int k) {
        
        priority_queue<int> pq;
        for (int num : nums) {
            pq.push(num);
        }
        while (k > 0 && pq.top() > 0) {
            pq.push(pq.top() - 1);
            pq.pop();
            k--;
        }
        return pq.top();
    }
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        int n = profits.size();
        vector<pair<int, int>> projects(n);
        for (int i = 0; i < n; ++i) {
            projects[i] = {capital[i], profits[i]};
        }
        sort(projects.begin(), projects.end());
        priority_queue<int> pq;
        int i = 0;
        while (k > 0) {
            while (i < n && projects[i].first <= w) {
                pq.push(projects[i].second);
                ++i;
            }
            if (!pq.empty()) {
                w += pq.top();
                pq.pop();
            }
            --k;
        }
        return w;
    }
};