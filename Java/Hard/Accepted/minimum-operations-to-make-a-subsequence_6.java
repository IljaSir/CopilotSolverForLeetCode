class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        int n = target.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                list.add(map.get(num));
            }
        }
        int len = list.size();
        int[] d = new int[len];
        int size = 0;
        for (int num : list) {
            int i = Arrays.binarySearch(d, 0, size, num);
            if (i < 0) {
                i = -(i + 1);
            }
            d[i] = num;
            if (i == size) {
                size++;
            }
        }
        return n - size;
    }
}