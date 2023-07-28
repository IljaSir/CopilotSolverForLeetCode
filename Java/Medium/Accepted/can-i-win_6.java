class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        return canWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean canWin(int length, int total, int used, Map<Integer, Boolean> memo) {
        if (memo.containsKey(used)) {
            return memo.get(used);
        }
        for (int i = 0; i < length; i++) {
            int cur = (1 << i);
            if ((cur & used) == 0) {
                if (total <= i + 1 || !canWin(length, total - (i + 1), cur | used, memo)) {
                    memo.put(used, true);
                    return true;
                }
            }
        }
        memo.put(used, false);
        return false;
    }
}