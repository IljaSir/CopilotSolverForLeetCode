class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        for (String s : supplies) {
            queue.offer(s);
        }
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (visited.contains(s)) {
                continue;
            }
            visited.add(s);
            for (String r : map.keySet()) {
                if (map.get(r).contains(s)) {
                    map.get(r).remove(s);
                    if (map.get(r).isEmpty()) {
                        res.add(r);
                    } else {
                        queue.addAll(map.get(r));
                    }
                }
            }
        }
        return res;
    }
}