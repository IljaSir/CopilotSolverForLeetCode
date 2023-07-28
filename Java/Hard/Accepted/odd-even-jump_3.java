class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> low = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> high = map.floorEntry(arr[i]);
            if (low != null) {
                odd[i] = even[low.getValue()];
            }
            if (high != null) {
                even[i] = odd[high.getValue()];
            }
            map.put(arr[i], i);
        }
        int res = 0;
        for (boolean b : odd) {
            if (b) {
                res++;
            }
        }
        return res;
    }
}