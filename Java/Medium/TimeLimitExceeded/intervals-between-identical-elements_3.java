class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(arr[i]);
            int m = list.size();
            for (int j = 0; j < m; j++) {
                ans[i] += Math.abs(list.get(j) - i);
            }
        }
        return ans;
    }
}