class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        
        String[] words = text.split(" ");
        List<String> out = new ArrayList<String>();
        for (int i=0; i<words.length-2; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                out.add(words[i+2]);
            }
        }
        return out.toArray(new String[out.size()]);
    }
}