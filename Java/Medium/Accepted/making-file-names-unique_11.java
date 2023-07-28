class Solution {
    public String[] getFolderNames(String[] names) {
        
        String[] result = new String[names.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < names.length; i++) {
            if(map.containsKey(names[i])) {
                int index = map.get(names[i]);
                String temp = names[i] + "(" + index + ")";
                while(map.containsKey(temp)) {
                    index++;
                    temp = names[i] + "(" + index + ")";
                }
                map.put(names[i], index + 1);
                map.put(temp, 1);
                result[i] = temp;
            } else {
                map.put(names[i], 1);
                result[i] = names[i];
            }
        }
        return result;
    }
}