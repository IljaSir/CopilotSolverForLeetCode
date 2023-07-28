class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> res = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foodSet.add(food);
            Map<String, Integer> foodMap = map.getOrDefault(table, new HashMap<>());
            foodMap.put(food, foodMap.getOrDefault(food, 0) + 1);
            map.put(table, foodMap);
        }
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodList);
        res.add(header);
        List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(tables);
        for (int table : tables) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            Map<String, Integer> foodMap = map.get(table);
            for (String food : foodList) {
                row.add(String.valueOf(foodMap.getOrDefault(food, 0)));
            }
            res.add(row);
        }
        return res;
    }
}