class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            if (map.containsKey(n)) {
                list.add(map.get(n));
            }
        }
        int[] dp = new int[list.size()];
        int len = 0;
        for (int n : list) {
            int i = Arrays.binarySearch(dp, 0, len, n);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = n;
            if (i == len) {
                len++;
            }
        }
        return target.length - len;
    }
}