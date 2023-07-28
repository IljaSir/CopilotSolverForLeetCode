class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int res = 0;
        priority_queue<int, vector<int>, less<int>> pq;
        pq.push(a);
        pq.push(b);
        pq.push(c);
        while (pq.size() >= 2) {
            int first = pq.top();
            pq.pop();
            int second = pq.top();
            pq.pop();
            if (first > 0 && second > 0) {
                res++;
                first--;
                second--;
                pq.push(first);
                pq.push(second);
            }
        }
        return res;
    }
};