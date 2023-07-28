class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int ans = 0;
        priority_queue<int> pq;
        pq.push(a);
        pq.push(b);
        pq.push(c);
        while (pq.size() >= 2) {
            int x = pq.top(); pq.pop();
            int y = pq.top(); pq.pop();
            if (x > 0 && y > 0) {
                ans++;
                x--;
                y--;
            }
            if (x > 0) pq.push(x);
            if (y > 0) pq.push(y);
        }
        return ans;
    }
};