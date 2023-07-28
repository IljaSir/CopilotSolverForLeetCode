class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int[] hash = new int[100];
        int count = 0;
        for (int[] domino : dominoes) {
            int num = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            count += hash[num];
            hash[num]++;
        }
        return count;
    }
}