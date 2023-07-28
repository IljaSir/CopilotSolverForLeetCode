class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Map<String, Integer>> tableMap = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            Map<String, Integer> foodMap = tableMap.getOrDefault(table, new HashMap<>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            tableMap.put(table, foodMap);
            foodSet.add(food);
        }
        List<Integer> tableList = new ArrayList<>(tableMap.keySet());
        Collections.sort(tableList);
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodList);
        result.add(header);
        for (int table : tableList) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            for (String food : foodList) {
                row.add(String.valueOf(tableMap.get(table).getOrDefault(food, 0)));
            }
            result.add(row);
        }
        return result;
    }
}