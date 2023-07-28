class Solution {
public:
    int longestWPI(vector<int>& hours) {
        
        int n = hours.size();
        vector<int> accu(n+1, 0);
        for (int i = 0; i < n; i++) {
            accu[i+1] = accu[i] + (hours[i] > 8 ? 1 : -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+res; j < n; j++) {
                if (accu[j+1] > accu[i]) {
                    res = j-i+1;
                }
            }
        }
        return res;
    }
};