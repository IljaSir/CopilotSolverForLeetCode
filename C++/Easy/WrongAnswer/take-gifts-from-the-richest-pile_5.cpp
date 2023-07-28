class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        priority_queue<int> pq;
        for (auto &x : gifts) {
            pq.push(x);
        }
        for (int i = 0; i < k; i++) {
            int t = pq.top();
            pq.pop();
            pq.push(t - sqrt(t));
        }
        long long res = 0;
        while (!pq.empty()) {
            res += pq.top();
            pq.pop();
        }
        return res;
    }
};