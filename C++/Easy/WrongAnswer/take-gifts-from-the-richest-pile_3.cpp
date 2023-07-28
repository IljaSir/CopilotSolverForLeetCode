class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        priority_queue<int> pq;
        for (auto& g : gifts) {
            pq.push(g);
        }
        while (k-- > 0) {
            int g = pq.top();
            pq.pop();
            pq.push(g - (int)sqrt(g));
        }
        long long ans = 0;
        while (!pq.empty()) {
            int g = pq.top();
            pq.pop();
            ans += g;
        }
        return ans;
    }
};