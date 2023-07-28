class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int[] t = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                t[0] = Math.max(t[0], triplet[0]);
                t[1] = Math.max(t[1], triplet[1]);
                t[2] = Math.max(t[2], triplet[2]);
            }
        }
        return t[0] == target[0] && t[1] == target[1] && t[2] == target[2];
    }
}