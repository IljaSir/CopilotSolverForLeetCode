class Solution {
public:
    bool isPossible(vector<int>& target) {
        
        priority_queue<int> pq;
        long long sum = 0;
        for (int i : target) {
            sum += i;
            pq.push(i);
        }
        while (true) {
            int num = pq.top();
            pq.pop();
            sum -= num;
            if (num == 1 || sum == 1) return true;
            if (num < sum || sum == 0 || num % sum == 0) return false;
            num %= sum;
            sum += num;
            pq.push(num);
        }
        return false;
    }
};