class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
        
        int n = colors.size(), res = 0;
        int i = 0, j = 0;
        while (i < n) {
            j = i;
            while (j < n && colors[j] == colors[i]) ++j;
            res += *max_element(neededTime.begin() + i, neededTime.begin() + j);
            i = j;
        }
        return res;
    }
};