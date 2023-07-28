class Solution {
    public String[] getFolderNames(String[] names) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int k = map.get(name);
                String newName = name + "(" + k + ")";
                while (map.containsKey(newName)) {
                    k++;
                    newName = name + "(" + k + ")";
                }
                map.put(newName, 1);
                map.put(name, k + 1);
                result[i] = newName;
            } else {
                map.put(name, 1);
                result[i] = name;
            }
        }
        return result;
    }
}