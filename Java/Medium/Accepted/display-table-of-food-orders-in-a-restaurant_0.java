class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<>();
        if (orders == null || orders.size() == 0) {
            return result;
        }
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> foodSet = new HashSet<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foodSet.add(food);
            Map<String, Integer> foodCountMap = map.getOrDefault(table, new HashMap<>());
            foodCountMap.put(food, foodCountMap.getOrDefault(food, 0) + 1);
            map.put(table, foodCountMap);
        }
        List<String> foodList = new ArrayList<>(foodSet);
        Collections.sort(foodList);
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodList);
        result.add(header);
        List<Integer> tableList = new ArrayList<>(map.keySet());
        Collections.sort(tableList);
        for (int table : tableList) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(table));
            for (String food : foodList) {
                list.add(String.valueOf(map.get(table).getOrDefault(food, 0)));
            }
            result.add(list);
        }
        return result;
    }
}