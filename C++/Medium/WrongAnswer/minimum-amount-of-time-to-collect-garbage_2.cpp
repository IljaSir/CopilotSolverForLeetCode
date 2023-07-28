class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
        
        int n = garbage.size();
        vector<int> metal(n), paper(n), glass(n);
        for (int i = 0; i < n; ++i) {
            metal[i] = paper[i] = glass[i] = 1e9;
            for (char c : garbage[i]) {
                if (c == 'M') metal[i] = 0;
                else if (c == 'P') paper[i] = 0;
                else glass[i] = 0;
            }
        }
        for (int i = 1; i < n; ++i) {
            metal[i] = min(metal[i], metal[i - 1] + travel[i - 1]);
            paper[i] = min(paper[i], paper[i - 1] + travel[i - 1]);
            glass[i] = min(glass[i], glass[i - 1] + travel[i - 1]);
            metal[i] = min(metal[i], paper[i - 1] + travel[i - 1]);
            metal[i] = min(metal[i], glass[i - 1] + travel[i - 1]);
            paper[i] = min(paper[i], metal[i - 1] + travel[i - 1]);
            paper[i] = min(paper[i], glass[i - 1] + travel[i - 1]);
            glass[i] = min(glass[i], metal[i - 1] + travel[i - 1]);
            glass[i] = min(glass[i], paper[i - 1] + travel[i - 1]);
        }
        return min({metal[n - 1], paper[n - 1], glass[n - 1]});
    }
};