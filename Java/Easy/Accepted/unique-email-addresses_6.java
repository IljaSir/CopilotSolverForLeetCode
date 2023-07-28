class Solution {
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            parts[0] = parts[0].replaceAll("\\.", "");
            parts[0] = parts[0].split("\\+")[0];
            set.add(parts[0] + "@" + parts[1]);
        }
        return set.size();
    }
}