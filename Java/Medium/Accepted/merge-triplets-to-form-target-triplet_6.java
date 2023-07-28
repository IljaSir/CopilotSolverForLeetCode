class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int x = target[0];
        int y = target[1];
        int z = target[2];
        int a = 0;
        int b = 0;
        int c = 0;
        for(int[] triplet: triplets) {
            if(triplet[0] <= x && triplet[1] <= y && triplet[2] <= z) {
                a = Math.max(a, triplet[0]);
                b = Math.max(b, triplet[1]);
                c = Math.max(c, triplet[2]);
            }
        }
        return a == x && b == y && c == z;
    }
}