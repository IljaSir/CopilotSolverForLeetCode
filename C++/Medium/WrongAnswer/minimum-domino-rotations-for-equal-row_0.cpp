class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int cnt[7] = {0};
        for (int i = 0; i < n; ++i) {
            cnt[tops[i]]++;
            cnt[bottoms[i]]++;
        }
        for (int i = 1; i <= 6; ++i) {
            if (cnt[i] >= n) {
                return n - max(count(tops.begin(), tops.end(), i), count(bottoms.begin(), bottoms.end(), i));
            }
        }
        return -1;
    }
};