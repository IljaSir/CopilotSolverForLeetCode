class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(arr[i]);
            long sum = 0;
            for (int j = 1; j < list.size(); j++) {
                sum += list.get(j) - list.get(j - 1);
            }
            ans[i] = sum;
        }
        return ans;
    }
}