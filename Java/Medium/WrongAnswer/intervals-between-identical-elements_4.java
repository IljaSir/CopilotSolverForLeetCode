class Solution {
    public long[] getDistances(int[] arr) {
        
        long[] result = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            int n = list.size();
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = list.get(0);
            right[n - 1] = arr.length - list.get(n - 1) - 1;
            for (int i = 1; i < n; i++) {
                left[i] = left[i - 1] + (list.get(i) - list.get(i - 1)) * i;
                right[n - i - 1] = right[n - i] + (list.get(n - i) - list.get(n - i - 1)) * i;
            }
            for (int i = 0; i < n; i++) {
                result[list.get(i)] = left[i] + right[i];
            }
        }
        return result;
    }
}