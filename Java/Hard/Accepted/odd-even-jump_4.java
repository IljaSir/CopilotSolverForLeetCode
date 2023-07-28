class Solution {
    public int oddEvenJumps(int[] arr) {
        
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        int count = 1;
        for (int i = n - 2; i >= 0; i--) {
            Integer next = map.ceilingKey(arr[i]);
            if (next != null) {
                odd[i] = even[map.get(next)];
            }
            next = map.floorKey(arr[i]);
            if (next != null) {
                even[i] = odd[map.get(next)];
            }
            if (odd[i]) {
                count++;
            }
            map.put(arr[i], i);
        }
        return count;
    }
}