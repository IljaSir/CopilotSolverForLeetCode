class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] result = new int[queryCharacters.length()];
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        for (int i = 0; i < queryCharacters.length(); i++) {
            char c = queryCharacters.charAt(i);
            int index = queryIndices[i];
            List<Integer> list = map.get(c);
            if (list == null) {
                result[i] = 1;
                continue;
            }
            int left = 0;
            int right = list.size();
            while (left < right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < index) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int l = 0;
            int r = 0;
            if (left < list.size() && list.get(left) == index) {
                l = left;
                r = left;
            } else if (left < list.size() && list.get(left) > index) {
                l = left - 1;
                r = left;
            } else if (left > 0) {
                l = left - 1;
                r = left - 1;
            }
            int count = 1;
            while (l >= 0 && list.get(l) > index - count) {
                count++;
                l--;
            }
            while (r < list.size() && list.get(r) < index + count) {
                count++;
                r++;
            }
            result[i] = count;
        }
        return result;
    }
}