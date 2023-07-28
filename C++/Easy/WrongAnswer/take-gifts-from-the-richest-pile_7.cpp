class Solution {
public:
    long long pickGifts(vector<int>& gifts, int k) {
        
        priority_queue<int> q;
        for (auto g : gifts) {
            q.push(g);
        }
        while (k > 0) {
            int cur = q.top();
            q.pop();
            q.push(cur / 2);
            k--;
        }
        long long ans = 0;
        while (!q.empty()) {
            ans += q.top();
            q.pop();
        }
        return ans;
    }
};