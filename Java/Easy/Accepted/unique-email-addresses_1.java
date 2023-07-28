class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int index = email.indexOf("@");
            String local = email.substring(0, index);
            String domain = email.substring(index);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", "");
            set.add(local + domain);
        }
        return set.size();
    }
}