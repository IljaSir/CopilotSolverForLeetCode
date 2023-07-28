class Solution {
public:
    bool canReach(vector<int>& arr, int start) {
        
        int n = arr.size();
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(start);
        visited[start] = true;
        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            if (arr[curr] == 0) {
                return true;
            }
            if (curr + arr[curr] < n && !visited[curr + arr[curr]]) {
                q.push(curr + arr[curr]);
                visited[curr + arr[curr]] = true;
            }
            if (curr - arr[curr] >= 0 && !visited[curr - arr[curr]]) {
                q.push(curr - arr[curr]);
                visited[curr - arr[curr]] = true;
            }
        }
        return false;
    }
};