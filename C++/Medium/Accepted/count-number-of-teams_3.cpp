class Solution {
public:
    int numTeams(vector<int>& rating) {
        
        int n = rating.size();
        int ans = 0;
        for (int i = 1; i < n-1; i++) {
            int l = 0, r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) l++;
            }
            for (int k = i+1; k < n; k++) {
                if (rating[i] < rating[k]) r++;
            }
            ans += l * r;
            l = r = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) l++;
            }
            for (int k = i+1; k < n; k++) {
                if (rating[i] > rating[k]) r++;
            }
            ans += l * r;
        }
        return ans;
    }
};