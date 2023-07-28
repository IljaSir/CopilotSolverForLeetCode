class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        if(buckets == 1) return 0;
        int pigs = 0;
        while(Math.pow(minutesToTest / minutesToDie + 1, pigs) < buckets) pigs++;
        return pigs;
    }
}