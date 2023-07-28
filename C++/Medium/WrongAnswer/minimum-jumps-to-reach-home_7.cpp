class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        int minJump = INT_MAX;
        queue<pair<int, bool>> q;
        unordered_set<int> visited;
        for (int i = 0; i < forbidden.size(); i++) {
            visited.insert(forbidden[i]);
        }
        q.push({0, false});
        visited.insert(0);
        int jump = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur.first == x) {
                    minJump = min(minJump, jump);
                }
                if (cur.first + a <= 6000 && visited.find(cur.first + a) == visited.end()) {
                    q.push({cur.first + a, false});
                    visited.insert(cur.first + a);
                }
                if (cur.first - b >= 0 && !cur.second && visited.find(cur.first - b) == visited.end()) {
                    q.push({cur.first - b, true});
                    visited.insert(cur.first - b);
                }
            }
            jump++;
        }
        return minJump == INT_MAX ? -1 : minJump;
    }
};