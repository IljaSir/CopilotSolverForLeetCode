class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        unordered_set<int> s;
        queue<int> q;
        q.push(0);
        s.insert(0);
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (int i : rooms[cur]) {
                if (s.find(i) == s.end()) {
                    q.push(i);
                    s.insert(i);
                }
            }
        }
        return s.size() == rooms.size();
    }
};