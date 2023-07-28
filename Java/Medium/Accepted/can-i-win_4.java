class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= 0) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        return canIWin(new HashMap<>(), maxChoosableInteger, desiredTotal, 0);
    }
    private boolean canIWin(Map<Integer, Boolean> map, int maxChoosableInteger, int desiredTotal, int state) {
        if (map.containsKey(state)) {
            return map.get(state);
        }
        for (int i = maxChoosableInteger; i > 0; i--) {
            int cur = 1 << (i - 1);
            if ((cur & state) == 0) {
                if (desiredTotal <= i || !canIWin(map, maxChoosableInteger, desiredTotal - i, cur | state)) {
                    map.put(state, true);
                    return true;
                }
            }
        }
        map.put(state, false);
        return false;
    }
}