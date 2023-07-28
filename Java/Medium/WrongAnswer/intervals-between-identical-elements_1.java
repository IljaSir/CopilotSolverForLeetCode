class Solution {
    public long[] getDistances(int[] arr) {
        
        long[] result = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            long distance = 0;
            for (int j = 0; j < list.size() - 1; j++) {
                distance += Math.abs(list.get(j) - list.get(j + 1));
            }
            result[i] = distance;
        }
        return result;
    }
}