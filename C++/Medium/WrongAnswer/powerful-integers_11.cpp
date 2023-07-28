class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        
        vector<int> ans;
        int i = 0, j = 0;
        int temp = 0;
        while (temp < bound) {
            temp = pow(x, i) + pow(y, j);
            if (temp <= bound) {
                ans.push_back(temp);
            }
            if (x == 1) {
                break;
            }
            if (y == 1) {
                break;
            }
            if (pow(x, i + 1) + pow(y, j) > bound) {
                i = 0;
                j++;
            } else {
                i++;
            }
        }
        sort(ans.begin(), ans.end());
        ans.erase(unique(ans.begin(), ans.end()), ans.end());
        return ans;
    }
};