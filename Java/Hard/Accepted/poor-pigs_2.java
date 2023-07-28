class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        int pigs = 0;
        int base = minutesToTest / minutesToDie + 1;
        while (Math.pow(base, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}