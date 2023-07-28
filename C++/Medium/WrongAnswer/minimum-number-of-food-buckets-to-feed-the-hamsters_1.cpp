class Solution {
public:
    int minimumBuckets(string hamsters) {
        
        int n = hamsters.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (hamsters[i] == 'H') {
                if (i > 0 && hamsters[i - 1] == '.') {
                    hamsters[i - 1] = 'B';
                    res++;
                } else if (i < n - 1 && hamsters[i + 1] == '.') {
                    hamsters[i + 1] = 'B';
                    res++;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }
};