class Solution {
public:
    int numberOfWeakCharacters(vector<vector<int>>& properties) {
        
        int n = properties.size();
        sort(properties.begin(), properties.end(), [](vector<int>& a, vector<int>& b) {
            if (a[0] == b[0]) {
                return a[1] > b[1];
            } else {
                return a[0] < b[0];
            }
        });
        int maxDefense = INT_MIN;
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                res++;
            } else {
                maxDefense = properties[i][1];
            }
        }
        return res;
    }
};