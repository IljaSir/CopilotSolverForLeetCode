class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        int n = target.size();
        priority_queue<int> pq;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += target[i];
            pq.push(target[i]);
        }
        while (true) {
            int x = pq.top();
            pq.pop();
            sum -= x;
            if (x == 1 || sum == 1) return true;
            if (x < sum || sum == 0 || x % sum == 0) return false;
            x %= sum;
            sum += x;
            pq.push(x);
        }
        return false;
    }
};