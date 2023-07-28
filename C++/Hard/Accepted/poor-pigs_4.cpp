class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int times = minutesToTest / minutesToDie;
        int pigs = 0;
        while (pow(times + 1, pigs) < buckets) {
            ++pigs;
        }
        return pigs;
    }
};