class Solution {
    public long[] getDistances(int[] arr) {
        
        int n = arr.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> l = map.getOrDefault(arr[i], new ArrayList<>());
            l.add(i);
            map.put(arr[i], l);
        }
        for(int i = 0; i < n; i++) {
            List<Integer> l = map.get(arr[i]);
            long sum = 0;
            for(int j = 1; j < l.size(); j++) {
                sum += l.get(j) - l.get(j - 1);
            }
            for(int j = 0; j < l.size(); j++) {
                ans[l.get(j)] = sum;
            }
        }
        return ans;
    }
}