class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int test = minutesToTest / minutesToDie;
        int pig = 0;
        while (pow(test + 1, pig) < buckets) {
            pig++;
        }
        return pig;
    }
};