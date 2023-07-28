class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null && index + i <= minSum) {
                if (index + i < minSum) {
                    result.clear();
                    minSum = index + i;
                }
                result.add(list2[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}