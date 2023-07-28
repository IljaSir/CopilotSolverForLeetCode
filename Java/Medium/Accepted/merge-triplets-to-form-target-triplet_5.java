class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int x = target[0];
        int y = target[1];
        int z = target[2];
        int xMax = 0;
        int yMax = 0;
        int zMax = 0;
        for (int[] triplet : triplets) {
            if (triplet[0] <= x && triplet[1] <= y && triplet[2] <= z) {
                xMax = Math.max(xMax, triplet[0]);
                yMax = Math.max(yMax, triplet[1]);
                zMax = Math.max(zMax, triplet[2]);
            }
        }
        return xMax == x && yMax == y && zMax == z;
    }
}