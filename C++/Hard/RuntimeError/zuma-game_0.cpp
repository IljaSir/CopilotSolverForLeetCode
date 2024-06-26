class Solution {
public:
    int findMinStep(string board, string hand) {
        
        unordered_map<char, int> mp;
        for (auto c : hand) {
            mp[c]++;
        }
        int res = dfs(board + "#", mp);
        return (res == INT_MAX) ? -1 : res;
    }
    int dfs(string board, unordered_map<char, int>& mp) {
        board = removeConsecutive(board);
        if (board == "#") return 0;
        int res = INT_MAX, need = 0;
        for (int i = 0, j = 0; j < board.size(); ++j) {
            if (board[i] == board[j]) continue;
            need = 3 - (j - i);
            if (mp[board[i]] >= need) {
                mp[board[i]] -= need;
                res = min(res, need + dfs(board.substr(0, i) + board.substr(j), mp));
                mp[board[i]] += need;
            }
            i = j;
        }
        return res;
    }
    string removeConsecutive(string s) {
        for (int i = 0, j = 0; j < s.size(); ++j) {
            if (s[i] == s[j]) continue;
            if (j - i >= 3) return removeConsecutive(s.substr(0, i) + s.substr(j));
            else i = j;
        }
        return s;
    }
};