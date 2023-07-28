class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        
        // BFS
        // 1. get start state
        // 2. get all possible next state
        // 3. get all next state
        // 4. if next state is target, return
        // 5. if next state is not visited, add it to queue
        // 6. if queue is empty, return -1
        // 7. if queue is not empty, goto 2.
        // 8. return -1
        string target = "123450";
        string start = "";
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board[i].size(); j++) {
                start += to_string(board[i][j]);
            }
        }
        if (start == target) return 0;
        
        unordered_set<string> visited;
        visited.insert(start);
        queue<string> q;
        q.push(start);
        
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string state = q.front();
                q.pop();
                vector<string> nextStates = getNextStates(state);
                for (auto nextState : nextStates) {
                    if (nextState == target) return steps + 1;
                    if (visited.find(nextState) == visited.end()) {
                        visited.insert(nextState);
                        q.push(nextState);
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
};