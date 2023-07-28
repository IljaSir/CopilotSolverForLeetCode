class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        Map<Integer, Set<Integer>> userLanguages = new HashMap<>();
        for (int i = 0; i < m; i++) {
            userLanguages.put(i + 1, new HashSet<>());
            for (int j = 0; j < languages[i].length; j++) {
                userLanguages.get(i + 1).add(languages[i][j]);
            }
        }
        Map<Integer, Set<Integer>> langUsers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            langUsers.put(i + 1, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                langUsers.get(languages[i][j]).add(i + 1);
            }
        }
        Map<Integer, Set<Integer>> friends = new HashMap<>();
        for (int i = 0; i < friendships.length; i++) {
            int u = friendships[i][0];
            int v = friendships[i][1];
            friends.putIfAbsent(u, new HashSet<>());
            friends.putIfAbsent(v, new HashSet<>());
            friends.get(u).add(v);
            friends.get(v).add(u);
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int lang = i + 1;
            int count = 0;
            Set<Integer> users = langUsers.get(lang);
            for (int user : users) {
                if (!hasCommonLanguage(user, userLanguages, lang, friends)) {
                    count++;
                }
            }
            result = Math.min(result, count);
        }
        return result;
    }
    
    private boolean hasCommonLanguage(int user, Map<Integer, Set<Integer>> userLanguages, int lang, Map<Integer, Set<Integer>> friends) {
        Set<Integer> friendList = friends.get(user);
        if (friendList == null) {
            return true;
        }
        for (int friend : friendList) {
            Set<Integer> langs = userLanguages.get(friend);
            if (langs.contains(lang)) {
                return true;
            }
        }
        return false;
    }
}