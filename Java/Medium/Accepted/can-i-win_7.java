class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) {
            return false;
        }
        return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int used, Map<Integer, Boolean> memo) {
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << (i - 1);
            if ((used & mask) == 0) {
                if (desiredTotal <= i || !canIWin(maxChoosableInteger, desiredTotal - i, used | mask, memo)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }
        memo.put(used, false);
        return false;
    }
}