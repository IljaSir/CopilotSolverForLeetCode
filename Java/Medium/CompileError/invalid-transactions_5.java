class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> res = new ArrayList<>();
        Map<String, List<int[]>> map = new HashMap<>();
        for (String s : transactions) {
            String[] arr = s.split(",");
            String name = arr[0];
            int time = Integer.parseInt(arr[1]);
            int amount = Integer.parseInt(arr[2]);
            String city = arr[3];
            if (amount > 1000) {
                res.add(s);
            }
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            }
            map.get(name).add(new int[]{time, amount, city});
        }
        for (String name : map.keySet()) {
            List<int[]> list = map.get(name);
            Collections.sort(list, (a,b) -> (a[0] - b[0]));
            for (int i = 0; i < list.size(); i++) {
                int[] a = list.get(i);
                if (a[1] > 1000) {
                    res.add(name + "," + a[0] + "," + a[1] + "," + a[2]);
                }
                for (int j = i + 1; j < list.size(); j++) {
                    int[] b = list.get(j);
                    if (b[0] - a[0] <= 60 && !a[2].equals(b[2])) {
                        res.add(name + "," + a[0] + "," + a[1] + "," + a[2]);
                        res.add(name + "," + b[0] + "," + b[1] + "," + b[2]);
                    }
                }
            }
        }
        return res;
    }
}