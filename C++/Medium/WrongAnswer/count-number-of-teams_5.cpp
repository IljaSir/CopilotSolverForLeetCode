class Solution {
public:
    int numTeams(vector<int>& rating) {
        
        int n = rating.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
                else if (rating[j] > rating[i]) r++;
            }
            res += l * (n - i - 1 - r);
            res += r * (i - l);
        }
        return res;
    }
};