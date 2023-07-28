class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        long long sum = 0;
        priority_queue<int> q;
        for (int t : target) {
            sum += t;
            q.push(t);
        }
        while (true) {
            int t = q.top();
            q.pop();
            sum -= t;
            if (t == 1 || sum == 1) return true;
            if (t < sum || sum == 0 || t % sum == 0) return false;
            t %= sum;
            sum += t;
            q.push(t);
        }
        return false;
    }
};