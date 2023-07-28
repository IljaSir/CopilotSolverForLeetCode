class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        List<Integer> result = new ArrayList<>();
        int n = security.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            if (i > time && security[i - time - 1] < security[i - time]) {
                left[i] = left[i - 1];
            } else {
                left[i] = security[i - time] <= security[i] ? left[i - 1] + 1 : 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (i < n - time - 1 && security[i + time + 1] < security[i + time]) {
                right[i] = right[i + 1];
            } else {
                right[i] = security[i + time] <= security[i] ? right[i + 1] + 1 : 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (left[i] >= time + 1 && right[i] >= time + 1) {
                result.add(i);
            }
        }
        return result;
    }
}