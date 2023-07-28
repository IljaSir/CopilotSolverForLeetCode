class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        
        // 把二维数组转换成一维数组
        string target = "123450";
        string start;
        for (auto& row : board) {
            for (auto& num : row) {
                start += to_string(num);
            }
        }
        // 用于存储每个状态下的下一步的所有状态
        vector<vector<int>> next_status = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        // 用于存储每个状态下的下一步的所有状态对应的移动方向
        vector<vector<char>> next_direction = {{'r'}, {'l', 'r'}, {'l'}, {'u', 'r'}, {'u', 'l', 'r'}, {'u', 'l'}};
        // 用于存储每个状态下的下一步的所有状态对应的移动步数
        vector<vector<int>> next_step = {{1}, {1, 1}, {1}, {1, 1}, {1, 1, 1}, {1, 1}};
        // 用于存储每个状态下的下一步的所有状态对应的移动方向
        vector<vector<char>> next_direction = {{'r'}, {'l', 'r'}, {'l'}, {'u', 'r'}, {'u', 'l', 'r'}, {'u', 'l'}};
        // 用于存储每个状态下的下一步的所有状态对应的移动步数
        vector<vector<int>> next_step = {{1}, {1, 1}, {1}, {1, 1}, {1, 1, 1}, {1, 1}};
        // 用于存储每个状态下的下一步的所有状态对应的移动方向
        vector<vector<char>> next_direction = {{'r'}, {'l', 'r'}, {'l'}, {'u', 'r'}, {'u', 'l', 'r'}, {'u', 'l'}};
        // 用于存储每个状态下的下一步的所有状态对应的移动
    }
};