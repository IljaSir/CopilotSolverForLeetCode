class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[] count = new int[n + 1];
        for (int key : map.keySet()) {
            count[map.get(key)]++;
        }
        int ans = 0;
        int sum = 0;
        for (int i = n; i >= 1; i--) {
            while (count[i]-- > 0) {
                sum += i;
                ans++;
                if (sum >= n / 2) {
                ount;
    }
}