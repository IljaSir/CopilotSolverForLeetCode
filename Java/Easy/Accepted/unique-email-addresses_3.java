class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String localName = parts[0];
            String domainName = parts[1];
            if (localName.contains("+")) {
                localName = localName.substring(0, localName.indexOf('+'));
            }
            localName = localName.replace(".", "");
            set.add(localName + "@" + domainName);
        }
        return set.size();
    }
}