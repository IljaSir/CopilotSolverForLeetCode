class Solution {
public:
    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        
        unordered_map<char, int> mp;
        for (char c: letters) mp[c]++;
        return dfs(words, 0, mp, score);
    }
    int dfs(vector<string>& words, int start, unordered_map<char, int> mp, vector<int>& score) {
        if (start == words.size()) return 0;
        int res = dfs(words, start + 1, mp, score);
        int tmp = 0;
        bool flag = true;
        for (char c: words[start]) {
            if (mp[c] == 0) {
                flag = false;
                break;
            }
            mp[c]--;
            tmp += score[c - 'a'];
        }
        if (flag) {
            res = max(res, tmp + dfs(words, start + 1, mp, score));
        }
        return res;
    }
};