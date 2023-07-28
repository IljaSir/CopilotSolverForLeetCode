class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        int[] dp = new int[list.size()];
        int len = 0;
        for (int num : list) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return target.length - len;
    }
}