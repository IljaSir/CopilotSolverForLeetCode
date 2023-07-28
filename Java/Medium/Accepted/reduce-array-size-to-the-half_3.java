class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> b - a);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i);
            if (ans >= n / 2) {
                return i + 1;
            }
        }
        return 0;
    }
}