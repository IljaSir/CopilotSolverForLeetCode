class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            map.put(arr[i], indices);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> indices = map.get(arr[i]);
            long sum = 0;
            for (int j = 0; j < indices.size(); j++) {
                sum += Math.abs(i - indices.get(j));
            }
            result[i] = sum;
        }
        return result;
    }
}