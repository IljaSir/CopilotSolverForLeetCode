class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            int time = Integer.parseInt(keyTime[i].replace(":", ""));
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(time);
        }
        for (String name : map.keySet()) {
            List<Integer> list = map.get(name);
            Collections.sort(list);
            for (int i = 0; i < list.size() - 2; i++) {
                if (list.get(i + 2) - list.get(i) <= 100) {
                    result.add(name);
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}