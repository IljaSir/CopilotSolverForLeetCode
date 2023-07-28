class Solution {
public:
    int numTeams(vector<int>& rating) {
        
        int n = rating.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
                if (rating[j] > rating[i]) r++;
            }
            for (int j = i+1; j < n; j++) {
                if (rating[j] < rating[i]) res += l;
                if (rating[j] > rating[i]) res += r;
            }
        }
        return res;
    }
};