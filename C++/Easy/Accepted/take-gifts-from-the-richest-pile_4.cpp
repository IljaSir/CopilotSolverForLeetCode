class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        priority_queue<int> pq;
        for (auto& g : gifts) {
            pq.push(g);
        }
        while (k--) {
            auto g = pq.top();
            pq.pop();
            g = sqrt(g);
            pq.push(g);
        }
        long long ans = 0;
        while (!pq.empty()) {
            ans += pq.top();
            pq.pop();
        }
        return ans;
    }
};