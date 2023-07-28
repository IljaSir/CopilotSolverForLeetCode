class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        
        List<List<String>> ans = new ArrayList<List<String>>();
        String[] food = new String[200];
        int[] count = new int[200];
        int foodCount = 0;
        int tableCount = 0;
        int[] table = new int[500];
        for (List<String> order : orders) {
            int tableNo = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            int i = 0;
            while (i < foodCount && !food[i].equals(foodItem)) {
                i++;
            }
            if (i == foodCount) {
                food[foodCount++] = foodItem;
            }
            if (table[tableNo] == 0) {
                table[tableNo] = 1;
                tableCount++;
            }
            count[i]++;
        }
        List<String> header = new ArrayList<String>();
        header.add("Table");
        for (int i = 0; i < foodCount; i++) {
            header.add(food[i]);
        }
        ans.add(header);
        for (int i = 1; i <= 500; i++) {
            if (table[i] == 0) {
                continue;
            }
            List<String> row = new ArrayList<String>();
            row.add("" + i);
            for (int j = 0; j < foodCount; j++) {
                int k = 0;
                while (k < orders.size() && !orders.get(k).get(1).equals("" + i)) {
                    k++;
                }
                int l = k;
                while (l < orders.size() && orders.get(l).get(1).equals("" + i) && !orders.get(l).get(2).equals(food[j])) {
                    l++;
                }
                row.add("" + (l - k));
            }
            ans.add(row);
        }
        return ans;
    }
}