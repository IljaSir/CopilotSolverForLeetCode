class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int index = map.get(list2[i]) + i;
                if (index < min) {
                    result.clear();
                    result.add(list2[i]);
                    min = index;
                } else if (index == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}