class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> memo = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int state, Map<Integer, Boolean> memo) {
        if (memo.containsKey(state)) {
            return memo.get(state);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << (i - 1);
            if ((state & cur) == 0) {
                if (desiredTotal - i <= 0 || !canIWin(maxChoosableInteger, desiredTotal - i, state | cur, memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        memo.put(state, false);
        return false;
    }
}