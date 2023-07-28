class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }
        Set<String> set = new HashSet<>();
        for (String s : supplies) {
            set.add(s);
        }
        for (String s : recipes) {
            if (canMake(s, map, set)) {
                res.add(s);
            }
        }
        return res;
    }
    private boolean canMake(String s, Map<String, List<String>> map, Set<String> set) {
        List<String> list = map.get(s);
        for (String str : list) {
            if (!set.contains(str)) {
                if (!canMake(str, map, set)) {
                    return false;
                }
            }
        }
        return true;
    }
}