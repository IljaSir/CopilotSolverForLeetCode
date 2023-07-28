class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        priority_queue<int> q;
        int sum = 0;
        for (int a : target) {
            sum += a;
            q.push(a);
        }
        while (true) {
            int a = q.top();
            q.pop();
            sum -= a;
            if (a == 1 || sum == 1) return true;
            if (a < sum || sum == 0 || a % sum == 0) return false;
            a %= sum;
            sum += a;
            q.push(a);
        }
        return true;
    }
};