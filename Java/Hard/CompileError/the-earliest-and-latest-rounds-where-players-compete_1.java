class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        int[] res = new int[2];
        res[0] = Math.min(earliest(n, firstPlayer, secondPlayer), earliest(n, secondPlayer, firstPlayer));
        res[1] = Math.max(latest(n, firstPlayer, secondPlayer), latest(n, secondPlayer, firstPlayer));
        return res;
    }
    
    private int earliest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer == secondPlayer) return 1;
        if (firstPlayer % 2 == 1 && secondPlayer == firstPlayer + 1) return 1;
        if (firstPlayer % 2 == 0 && secondPlayer == firstPlayer - 1) return 1;
        if (firstPlayer % 2 == 1 && secondPlayer == firstPlayer + 2) return 2;
        if (firstPlayer % 2 == 0 && secondPlayer == firstPlayer - 2) return 2;
        return 1 + earliest(n / 2, (firstPlayer + 1) / 2, (secondPlayer + 1) / 2);
    }
}