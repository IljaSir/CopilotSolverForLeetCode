class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> result = new ArrayList<>();
        int[] maxBefore = new int[security.length];
        int[] minAfter = new int[security.length];
        maxBefore[0] = security[0];
        minAfter[security.length - 1] = security[security.length - 1];
        for (int i = 1; i < security.length; i++) {
            maxBefore[i] = Math.max(maxBefore[i - 1], security[i]);
            minAfter[security.length - 1 - i] = Math.min(minAfter[security.length - i], security[security.length - 1 - i]);
        }
        for (int i = 0; i < security.length; i++) {
            if (i - time >= 0 && i + time < security.length) {
                if (maxBefore[i - time] >= security[i] && minAfter[i + time] >= security[i]) {
                    result.add(i);
                }
            } else if (i - time < 0) {
                if (minAfter[i + time] >= security[i]) {
                    result.add(i);
                }
            } else if (i + time >= security.length) {
                if (maxBefore[i - time] >= security[i]) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}