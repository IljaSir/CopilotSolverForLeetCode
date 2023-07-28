class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        Set<String> foodNames = new HashSet<>();
        Map<Integer, Map<String, Integer>> tableMap = new TreeMap<>();
        for (List<String> order : orders) {
            String foodName = order.get(2);
            foodNames.add(foodName);
            int tableNumber = Integer.parseInt(order.get(1));
            Map<String, Integer> foodMap = tableMap.getOrDefault(tableNumber, new HashMap<>());
            foodMap.put(foodName, foodMap.getOrDefault(foodName, 0) + 1);
            tableMap.put(tableNumber, foodMap);
        }
        List<String> foodList = new ArrayList<>(foodNames);
        Collections.sort(foodList);
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodList);
        result.add(header);
        for (int tableNumber : tableMap.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(tableNumber));
            Map<String, Integer> foodMap = tableMap.get(tableNumber);
            for (String foodName : foodList) {
                row.add(String.valueOf(foodMap.getOrDefault(foodName, 0)));
            }
            result.add(row);
        }
        return result;
    }
}