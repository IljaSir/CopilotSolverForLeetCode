class Solution {
    public boolean isPrefixString(String s, String[] words) {
        
        var builder = new StringBuilder();
        for (var word : words) {
            builder.append(word);
            if (builder.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}