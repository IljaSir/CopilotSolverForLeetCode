class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        Set<String> items = new HashSet<>();
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            items.add(food);
            Map<String, Integer> tableMap = map.getOrDefault(table, new HashMap<>());
            tableMap.put(food, tableMap.getOrDefault(food, 0) + 1);
            map.put(table, tableMap);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        List<String> itemsList = new ArrayList<>(items);
        Collections.sort(itemsList);
        header.addAll(itemsList);
        res.add(header);
        for (int table : map.keySet()) {
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            for (String item : itemsList) {
                row.add(String.valueOf(map.get(table).getOrDefault(item, 0)));
            }
            res.add(row);
        }
        return res;
    }
}