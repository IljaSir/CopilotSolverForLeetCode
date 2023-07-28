class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        Set<String> foodItems = new HashSet<>();
        Map<Integer, Map<String, Integer>> tableMap = new TreeMap<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foodItems.add(food);
            tableMap.computeIfAbsent(table, k -> new HashMap<>()).merge(food, 1, Integer::sum);
        }
        List<String> header = new ArrayList<>(foodItems);
        Collections.sort(header);
        header.add(0, "Table");
        result.add(header);
        for (Map.Entry<Integer, Map<String, Integer>> entry : tableMap.entrySet()) {
            List<String> row = new ArrayList<>();
            row.add(entry.getKey().toString());
            for (String food : header) {
                if (food.equals("Table")) {
                    continue;
                }
                row.add(entry.getValue().getOrDefault(food, 0).toString());
            }
            result.add(row);
        }
        return result;
    }
}