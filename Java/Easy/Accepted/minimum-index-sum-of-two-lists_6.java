class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < min) {
                    result = new ArrayList<String>();
                    result.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}