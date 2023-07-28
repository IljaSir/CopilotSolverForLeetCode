class Solution {
    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;
        List<Integer> list = new ArrayList<>();
        for (int c : candidates) {
            list.add(c);
        }
        Collections.sort(list, (a, b) -> {
            if ((a & b) == 0) {
                return b - a;
            } else {
                return Integer.bitCount(b) - Integer.bitCount(a);
            }
        });
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((list.get(i) & list.get(j)) > 0) {
                    res = Math.max(res, Integer.bitCount(list.get(i)) + Integer.bitCount(list.get(j)));
                }
            }
        }
        return res;
    }
}