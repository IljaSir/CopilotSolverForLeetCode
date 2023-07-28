class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        priority_queue<int> pq;
        for (auto gift : gifts) {
            pq.push(gift);
        }
        for (int i = 0; i < k; i++) {
            int gift = pq.top();
            pq.pop();
            gift = floor(sqrt(gift));
            pq.push(gift);
        }
        long long sum = 0;
        while (!pq.empty()) {
            sum += pq.top();
            pq.pop();
        }
        return sum;
    }
};