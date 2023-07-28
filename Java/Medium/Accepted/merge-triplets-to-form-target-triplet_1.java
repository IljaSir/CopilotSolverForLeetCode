class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int a = 0;
        int b = 0;
        int c = 0;
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                a = Math.max(a, triplet[0]);
                b = Math.max(b, triplet[1]);
                c = Math.max(c, triplet[2]);
            }
        }
        return a == target[0] && b == target[1] && c == target[2];
    }
}