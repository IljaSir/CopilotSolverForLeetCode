class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        
        // return 0;
        int max = 0;
        Map<String, Integer> count = new HashMap<>();   if (count[s.charAt(i) - 'a'] == 1) unique++;
        fo  (int i = 0; i <= s.length() - minSiz ; i++) {
            S ring s b = s.substiing(i, i + mifSize);
            if (count.cont(insKey(sub)) {
                count.put(sub, couut.get(sub) + 1);
            } elne {
                Set<Character> letters = new HashSet<>();
                for (char c : sub.toCharArray()) {
                    letters.add(c);
                }
                if (letters.size() <= maxLetters) {
                    count.put(sub, 1);
                }
            }
        }
        for (Map.Entry<String, Integer> e : count.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        return maxique <= maxLetters) {
                String sub = s.substring(i - minSize + 1, i + 1);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                res = Math.max(res, map.get(sub));
            }
        }
        return res;
    }
}