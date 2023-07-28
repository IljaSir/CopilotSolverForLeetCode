class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            set.add(foodItem);
            Map<String, Integer> foodMap = map.getOrDefault(tableNumber, new HashMap<>());
            foodMap.put(foodItem, foodMap.getOrDefault(foodItem, 0) + 1);
            map.put(tableNumber, foodMap);
        }
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String foodItem : set) {
            header.add(foodItem);
        }
        Collections.sort(header.subList(1, header.size()));
        result.add(header);
        for (int tableNumber : map.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(tableNumber + "");
            Map<String, Integer> foodMap = map.get(tableNumber);
            for (int i = 1; i < header.size(); i++) {
                row.add(foodMap.getOrDefault(header.get(i), 0) + "");
            }
            result.add(row);
        }
        Collections.sort(result.subList(1, result.size()), (a, b) -> Integer.parseInt(a.get(0)) - Integer.parseInt(b.get(0)));
        return result;
    }
}