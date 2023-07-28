class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int k = minutesToTest / minutesToDie;
        int pigs = 0;
        while (pow(k + 1, pigs) < buckets) pigs++;
        return pigs;
    }
};