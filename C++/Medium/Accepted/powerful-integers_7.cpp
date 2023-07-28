class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        int i = 1, j = 1;
        vector<int> ans;
        while (i < bound) {
            j = 1;
            while (i + j <= bound) {
                ans.push_back(i + j);
                if (y == 1) break;
                j *= y;
            }
            if (x == 1) break;
            i *= x;
        }
        sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return ans;
    }
};