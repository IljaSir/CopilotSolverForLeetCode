class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        int n = beans.size();
        long long sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += beans[i];
        }
        long long avg = sum / n;
        long long mod = sum % n;
        long long res = 0;
        for (int i = 0; i < n; ++i) {
            if (beans[i] > avg) {
                if (i < mod) {
                    res += beans[i] - avg - 1;
                } else {
                    res += beans[i] - avg;
                }
            }
        }
        return res;
    }
};