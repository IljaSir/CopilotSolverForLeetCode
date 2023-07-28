class Solution {
public:
    int eliminateMaximum(vector<int>& dist, vector<int>& speed) {
        
        int n = dist.size();
        vector<double> t(n);
        for(int i = 0; i < n; i++) {
            t[i] = (double) dist[i] / speed[i];
        }
        sort(t.begin(), t.end());
        int i = 0;
        while(i < n && t[i] > i) i++;
        return i;
    }
};