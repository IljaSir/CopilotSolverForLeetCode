class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> res = new ArrayList<>();
        Map<String, List<int[]>> map = new HashMap<>();
        for (String transaction : transactions) {
            String[] strs = transaction.split(",");
            String name = strs[0];
            int time = Integer.parseInt(strs[1]);
            int amount = Integer.parseInt(strs[2]);
            String city = strs[3];
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(new int[]{time, amount, city});
        }
        for (String name : map.keySet()) {
            List<int[]> list = map.get(name);
            Collections.sort(list, (a, b) -> a[0] - b[0]);
            int n = list.size();
            int[] prev = list.get(0);
            boolean invalid = false;
            for (int i = 1; i < n; i++) {
                int[] cur = list.get(i);
                if (prev[2] != cur[2] && cur[0] - prev[0] <= 60) {
                    invalid = true;
                    break;
                }
                prev = cur;
            }
            if (invalid) {
                for (int[] arr : list) {
                    res.add(name + "," + arr[0] + "," + arr[1] + "," + arr[2]);
                }
            } else {
                for (int[] arr : list) {
                    if (arr[1] > 1000) {
                        res.add(name + "," + arr[0] + "," + arr[1] + "," + arr[2]);
                    }
                }
            }
        }
        return res;
    }
}