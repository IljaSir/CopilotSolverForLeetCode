class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;
        if (n == 1) return 1;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> higher = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lower = map.floorEntry(arr[i]);
            if (higher != null) {
                odd[i] = even[higher.getValue()];
            }
            if (lower != null) {
                even[i] = odd[lower.getValue()];
            }
            if (odd[i]) res++;
            map.put(arr[i], i);
        }
        return res;
    }
}