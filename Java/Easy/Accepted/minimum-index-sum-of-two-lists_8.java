class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = map.get(list2[i]) + i;
                if (sum < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}