class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        priority_queue<int> pq;
        int n = capacity.size();
        for (int i = 0; i < n; ++i) {
            pq.push(capacity[i] - rocks[i]);
        }
        while (additionalRocks > 0) {
            int x = pq.top();
            pq.pop();
            if (x == 0) {
                pq.push(0);
                break;
            }
            pq.push(x - 1);
            --additionalRocks;
        }
        int ans = 0;
        while (!pq.empty()) {
            if (pq.top() == 0) {
                ++ans;
            }
            pq.pop();
        }
        return ans;
    }
};