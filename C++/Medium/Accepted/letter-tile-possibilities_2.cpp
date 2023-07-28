class Solution {
public:
    int numTilePossibilities(string tiles) {
        
        vector<int> counter(26);
        for (char c : tiles) {
            counter[c - 'A']++;
        }
        return dfs(counter);
    }
    
    int dfs(vector<int>& counter) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (counter[i] == 0) continue;
            sum++;
            counter[i]--;
            sum += dfs(counter);
            counter[i]++;
        }
        return sum;
    }
};