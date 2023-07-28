class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length;
        for(int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }
        int[] dp = new int[list.size()];
        int len = 0;
        for(int i = 0; i < list.size(); i++) {
            int index = Arrays.binarySearch(dp, 0, len, list.get(i));
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = list.get(i);
            if(index == len) {
                len++;
            }
        }
        return n - len;
    }
}