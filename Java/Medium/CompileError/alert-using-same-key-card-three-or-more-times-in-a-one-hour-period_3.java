class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
            map.putIfAbsent(name, new ArrayList<>());
        L st<ap.get(name).add(minutes);
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            for (int i = 0; i < times.size() - 2; i++) {
                if (times.get(i + 2) - times.get(i) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}