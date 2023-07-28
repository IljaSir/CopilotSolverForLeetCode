class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        
        priority_queue<int> pq;
        for (auto p : piles) {
            pq.push(p);
        }
        while (k > 0) {
            int p = pq.top();
            pq.pop();
            pq.push(p - p / 2);
            k--;
        }
        int sum = 0;
        while (!pq.empty()) {
            sum += pq.top();
            pq.pop();
        }
        return sum;
    }
};