class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] countDomain = cpdomain.split(" ");
            int count = Integer.parseInt(countDomain[0]);
            String domain = countDomain[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    map.put(domain.substring(i + 1), map.getOrDefault(domain.substring(i + 1), 0) + count);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}