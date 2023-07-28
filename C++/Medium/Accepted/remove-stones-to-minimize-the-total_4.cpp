class Solution {
public:
    int minStoneSum(vector<int>& piles, int k) {
        
        priority_queue<int> pq;
        for (int pile : piles) {
            pq.push(pile);
        }
        while (k > 0) {
            int top = pq.top();
            pq.pop();
            pq.push((top + 1) / 2);
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