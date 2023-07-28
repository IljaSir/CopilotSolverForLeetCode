class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) < minSum) {
                    res.clear();
                    res.add(list2[i]);
                    minSum = i + map.get(list2[i]);
                } else if (i + map.get(list2[i]) == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}