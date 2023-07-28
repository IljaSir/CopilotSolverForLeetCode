class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        int[] num = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            int d = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
            res += num[d];
            num[d]++;
        }
        return res;
    }
}