class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        int ans = 1;
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]);
            Map.Entry<Integer, Integer> lo = map.floorEntry(arr[i]);
            if (hi != null) {
                odd[i] = even[hi.getValue()];
            }
            if (lo != null) {
                even[i] = odd[lo.getValue()];
            }
            if (odd[i]) {
                ans++;
            }
            map.put(arr[i], i);
        }
        return ans;
    }
}