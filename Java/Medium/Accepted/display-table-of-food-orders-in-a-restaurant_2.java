class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> result = new ArrayList<List<String>>();
        Set<String> foodSet = new HashSet<String>();
        for (List<String> order : orders) {
            foodSet.add(order.get(2));
        }
        List<String> foodList = new ArrayList<String>();
        for (String food : foodSet) {
            foodList.add(food);
        }
        Collections.sort(foodList);
        Map<Integer, Map<String, Integer>> tableMap = new HashMap<Integer, Map<String, Integer>>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (!tableMap.containsKey(tableNumber)) {
                tableMap.put(tableNumber, new HashMap<String, Integer>());
            }
            Map<String, Integer> foodMap = tableMap.get(tableNumber);
            if (!foodMap.containsKey(food)) {
                foodMap.put(food, 0);
            }
            foodMap.put(food, foodMap.get(food) + 1);
        }
        List<Integer> tableList = new ArrayList<Integer>();
        for (Integer tableNumber : tableMap.keySet()) {
            tableList.add(tableNumber);
        }
        Collections.sort(tableList);
        List<String> header = new ArrayList<String>();
        header.add("Table");
        header.addAll(foodList);
        result.add(header);
        for (Integer tableNumber : tableList) {
            List<String> row = new ArrayList<String>();
            row.add(tableNumber.toString());
            Map<String, Integer> foodMap = tableMap.get(tableNumber);
            for (String food : foodList) {
                if (!foodMap.containsKey(food)) {
                    row.add("0");
                } else {
                    row.add(foodMap.get(food).toString());
                }
            }
            result.add(row);
        }
        return result;
    }
}