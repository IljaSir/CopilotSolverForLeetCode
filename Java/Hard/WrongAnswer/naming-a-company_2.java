class Solution {
    public long distinctNames(String[] ideas) {
        
        Set<String> set = new HashSet<>(Arrays.asList(ideas));
        long result = 0;
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                char[] chars = ideas[i].toCharArray();
                char temp = chars[0];
                chars[0] = ideas[j].charAt(0);
                String newString = new String(chars);
                if (!set.contains(newString)) {
                    result++;
                }
                chars[0] = temp;
                chars = ideas[j].toCharArray();
                chars[0] = ideas[i].charAt(0);
                newString = new String(chars);
                if (!set.contains(newString)) {
                    result++;
                }
            }
        }
        return result;
    }
}