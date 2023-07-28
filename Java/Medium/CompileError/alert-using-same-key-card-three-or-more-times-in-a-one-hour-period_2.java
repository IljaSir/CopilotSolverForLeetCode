class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(convert(time));
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Integer> times = map.get(name);
            Collections.sort(times);
            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    res.add(name);
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}