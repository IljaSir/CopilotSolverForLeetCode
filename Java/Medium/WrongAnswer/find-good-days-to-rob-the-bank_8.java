class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> result = new ArrayList<>();
        int[] maxBefore = new int[security.length];
        int[] minAfter = new int[security.length];
        int max = 0;
        for (int i = 0; i < security.length; i++) {
            maxBefore[i] = max;
            max = Math.max(max, security[i]);
        }
        int min = Integer.MAX_VALUE;
        for (int i = security.length - 1; i >= 0; i--) {
            minAfter[i] = min;
            min = Math.min(min, security[i]);
        }
        for (int i = 0; i < security.length; i++) {
            if (security[i] >= maxBefore[i] && security[i] <= minAfter[i]) {
                result.add(i);
            }
        }
        return result;
    }
}