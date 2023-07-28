class Solution {
public:
    int minimumOperations(vector<int>& nums, int start, int goal) {
        
        unordered_set<int> visited;
        queue<int> q;
        q.push(start);
        visited.insert(start);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front();
                q.pop();
                if (cur == goal) return step;
                for (int num : nums) {
                    int next = cur + num;
                    if (next <= 1000 && !visited.count(next)) {
                        q.push(next);
                        visited.insert(next);
                    }
                    next = cur - num;
                    if (next >= 0 && !visited.count(next)) {
                        q.push(next);
                        visited.insert(next);
                    }
                    next = cur ^ num;
                    if (next >= 0 && !visited.count(next)) {
                        q.push(next);
                        visited.insert(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};