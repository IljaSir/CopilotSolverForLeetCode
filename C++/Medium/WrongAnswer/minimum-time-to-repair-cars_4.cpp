class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int r : ranks) pq.push(r);
        while (cars--) {
            int r = pq.top(); pq.pop();
            pq.push(r + 1);
        }
        return (long long)pq.top() * pq.top() * cars;
    }
};