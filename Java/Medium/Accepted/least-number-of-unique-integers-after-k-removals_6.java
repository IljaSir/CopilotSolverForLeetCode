class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        var map = new HashMap<Integer, Integer>();
        for (var a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        var list = new ArrayList<Integer>(map.values());
        Collections.sort(list);
        var count = 0;
        for (var i = 0; i < list.size(); i++) {
            if (k >= list.get(i)) {
                k -= list.get(i);
                count++;
            }
        }
        return list.size() - count;
    }
}