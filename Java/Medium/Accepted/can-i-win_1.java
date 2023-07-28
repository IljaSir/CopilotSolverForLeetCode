class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        return canIWin(maxChoosableInteger, desiredTotal, 0, map);
    }
    private boolean canIWin(int maxChoosableInteger, int desiredTotal, int used, Map<Integer, Boolean> map) {
        if (map.containsKey(used)) {
            return map.get(used);
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur = 1 << i;
            if ((used & cur) == 0) {
                if (i >= desiredTotal || !canIWin(maxChoosableInteger, desiredTotal - i, used | cur, map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }
}