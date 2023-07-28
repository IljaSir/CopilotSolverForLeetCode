class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        int N = arr.size();
        unordered_map<int, vector<int>> idx;
        for (int i = 0; i < N; ++i) idx[arr[i]].push_back(i);
        vector<int> seen(N);
        queue<int> q;
        q.push(0);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                int i = q.front(); q.pop();
                if (i == N - 1) return step;
                if (seen[i]) continue;
                seen[i] = 1;
                if (i - 1 >= 0 && !seen[i - 1]) q.push(i - 1);
                if (i + 1 < N && !seen[i + 1]) q.push(i + 1);
                for (int j : idx[arr[i]]) {
                    if (!seen[j]) q.push(j);
                }
                idx.erase(arr[i]);
            }
            ++step;
        }
        return -1;
    }
};