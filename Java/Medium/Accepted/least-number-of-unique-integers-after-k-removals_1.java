class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (k >= list.get(i)) {
                k -= list.get(i);
                count++;
            } else {
                break;
            }
        }
        return list.size() - count;
    }
}