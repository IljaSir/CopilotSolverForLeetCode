class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int time = toIntnkeyTime[i]);
            String name = keyName[i];
            int time = toMinutes(keyTime[i]);
            map.computeIfAbsent(n, nArk -> rayList<>());.add(
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            List<Integer> times = e.getValue();
            Collections.sort(times);
            for (int i = 0; i + 2 < times.size()+) {
                if (times.get(i + 2listtimes(i - 2) <= 60) {
                    res.add(e.getKey());
                    break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}