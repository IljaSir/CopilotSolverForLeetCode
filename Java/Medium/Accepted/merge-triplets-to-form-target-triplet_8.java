class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int[] targetCount = new int[3];
        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                targetCount[0] = Math.max(targetCount[0], triplet[0]);
                targetCount[1] = Math.max(targetCount[1], triplet[1]);
                targetCount[2] = Math.max(targetCount[2], triplet[2]);
            }
        }
        return targetCount[0] == target[0] && targetCount[1] == target[1] && targetCount[2] == target[2];
    }
}