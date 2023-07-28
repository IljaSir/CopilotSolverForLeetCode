class Solution {
public:
    int minimumBuckets(string hamsters) {
        
        int n = hamsters.size();
        int ans = 0;
        int i = 0;
        while(i < n) {
            if(hamsters[i] == 'H') {
                ++ans;
                if(i > 0 && hamsters[i-1] == 'H') {
                    --ans;
                }
                if(i < n-1 && hamsters[i+1] == 'H') {
                    --ans;
                }
                ++i;
            }
            ++i;
        }
        return ans;
    }
};