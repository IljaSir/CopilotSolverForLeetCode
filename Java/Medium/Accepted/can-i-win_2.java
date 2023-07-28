class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        return canIWin(maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean canIWin(int length, int total, int used, Map<Integer, Boolean> map) {
        if (map.containsKey(used)) {
            return map.get(used);
        }
        for (int i = 0; i < length; i++) {
            int cur = 1 << i;
            if ((used & cur) == 0) {
                if (total <= i + 1 || !canIWin(length, total - (i + 1), used | cur, map)) {
                    map.put(used, true);
                    return true;
                }
            }
        }
        map.put(used, false);
        return false;
    }
}