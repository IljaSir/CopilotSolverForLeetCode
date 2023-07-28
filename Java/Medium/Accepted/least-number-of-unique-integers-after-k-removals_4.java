class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>(map.values());
        Collections.sort(list);
        int index = 0;
        while (k > 0) {
            k -= list.get(index);
            index++;
        }
        return k == 0 ? list.size() - index : list.size() - index + 1;
    }
}