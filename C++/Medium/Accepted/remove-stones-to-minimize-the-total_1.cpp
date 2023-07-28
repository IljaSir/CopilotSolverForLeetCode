class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        
        priority_queue<int> pq;
        for (int p : piles) {
            pq.push(p);
        }
        while (k--) {
            int t = pq.top();
            pq.pop();
            pq.push(t - t / 2);
        }
        int ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
};