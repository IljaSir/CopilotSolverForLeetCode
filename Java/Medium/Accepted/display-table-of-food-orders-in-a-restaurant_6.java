class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        TreeSet<String> foodSet = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> tableMap = new TreeMap<>();
        for (List<String> order : orders) {
            String food = order.get(2);
            foodSet.add(food);
            int table = Integer.parseInt(order.get(1));
            Map<String, Integer> foodMap = tableMap.getOrDefault(table, new HashMap<String, Integer>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            tableMap.put(table, foodMap);
        }
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodSet);
        result.add(header);
        for (Map.Entry<Integer, Map<String, Integer>> entry : tableMap.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(entry.getKey()));
            for (String food : foodSet) {
                row.add(String.valueOf(entry.getValue().getOrDefault(food, 0)));
            }
            result.add(row);
        }
        return result;
    }
}