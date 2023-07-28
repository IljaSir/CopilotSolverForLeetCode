class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        int len = startGene.length();
        Map<String, List<String>> map = new HashMap<>();
        for (String gene : bank) {
            for (int i = 0; i < len; i++) {
                String key = gene.substring(0, i) + "*" + gene.substring(i + 1);
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(gene);
                map.put(key, list);
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String gene = queue.poll();
                if (gene.equals(endGene)) {
                    return level;
                }
                for (int j = 0; j < len; j++) {
                    String key = gene.substring(0, j) + "*" + gene.substring(j + 1);
                    for (String nextGene : map.getOrDefault(key, new ArrayList<>())) {
                        if (!visited.contains(nextGene)) {
                            queue.add(nextGene);
                            visited.add(nextGene);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}