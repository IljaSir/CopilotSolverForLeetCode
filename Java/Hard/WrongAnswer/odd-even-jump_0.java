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
            int v = arr[i];
            if (map.containsKey(v)) {
                odd[i] = even[map.get(v)];
                even[i] = odd[map.get(v)];
            } else {
                Integer hi = map.ceilingKey(v);
                Integer lo = map.floorKey(v);
                if (hi != null) {
                    even[i] = odd[map.get(hi)];
                }
                if (lo != null) {
                    odd[i] = even[map.get(lo)];
                }
            }
            if (odd[i]) {
                ans++;
            }
            map.put(v, i);
        }
        return ans;
    }
}