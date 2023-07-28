class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int n = minutesToTest / minutesToDie;
        int m = 0;
        while (pow(n + 1, m) < buckets) {
            m++;
        }
        return m;
    }
};