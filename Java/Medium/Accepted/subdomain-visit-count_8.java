class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] cpInfo = cpdomain.split(" ");
            int count = Integer.parseInt(cpInfo[0]);
            String domain = cpInfo[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        return result;
    }
}