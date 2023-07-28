class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : supplies) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (int i = 0; i < recipes.length; i++) {
            if (canMake(map, ingredients.get(i))) {
                result.add(recipes[i]);
            }
        }
        return result;
    }
    private boolean canMake(Map<String, Integer> map, List<String> list) {
        for (String s : list) {
            if (map.containsKey(s)) {
                if (map.get(s) > 0) {
                    map.put(s, map.get(s) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}