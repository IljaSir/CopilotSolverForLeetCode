class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int i = 0;
        while (i < list.size() && k > 0) {
            k -= list.get(i);
            i++;
        }
        return k >= 0 ? list.size() - i : list.size() - i + 1;
    }
}