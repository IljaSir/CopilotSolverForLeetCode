class Solution {
    public int[] groupStrings(String[] words) {
        
        int[] ans = new int[2];
        int maxGroup = 0;
        int maxGroupSize = 0;
        List<List<String>> groups = new ArrayList<List<String>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            int groupIndex = -1;
            for (int j = 0; j < groups.size(); j++) {
                List<String> group = groups.get(j);
                String groupWord = group.get(0);
                if (word.length() == groupWord.length()) {
                    int diff = word.charAt(0) - groupWord.charAt(0);
                    if (diff < 0) {
                        diff += 26;
                    }
                    boolean isGroup = true;
                    for (int k = 0; k < word.length(); k++) {
                        int groupChar = groupWord.charAt(k) + diff;
                        if (groupChar > 'z') {
                            groupChar -= 26;
                        }
                        if (word.charAt(k) != groupChar) {
                            isGroup = false;
                            break;
                        }
                    }
                    if (isGroup) {
                        groupIndex = j;
                        break;
                    }
                }
            }
            if (groupIndex == -1) {
                List<String> group = new ArrayList<String>();
                group.add(word);
                groups.add(group);
            } else {
                List<String> group = groups.get(groupIndex);
                group.add(word);
            }
        }
        for (int i = 0; i < groups.size(); i++) {
            List<String> group = groups.get(i);
            if (group.size() > maxGroupSize) {
                maxGroupSize = group.size();
            }
        }
        ans[0] = groups.size();
        ans[1] = maxGroupSize;
        return ans;
    }
}