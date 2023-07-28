class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word: words) {
            int mask = 0;
            for (char ch: word.toCharArray()) {
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle: puzzles) {
            int total = 0;

            // 枚举子集方法一
            for (int choose = 0; choose < 1 << 6; choose++) {
                int mask = 0;
                for (int i = 0; i < 6; ++i) {
                    if ((choose & (1 << i)) != 0) {
                        mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
                    }
                }
                mask |= (1 << (puzzle.charAt(0) - 'a'));
                if (freq.containsKey(mask)) {
                    total += freq.get(mask);
                }
            }

            // 枚举子集方法二
            // int mask = 0;
            // for (char ch: puzzle.toCharArray()) {
            //     mask |= (1 << (ch - 'a'));
            // }
            // int subset = mask;
            // while (subset != 0) {
            //     subset = (subset - 1) & mask;
            //     int s = subset | (1 << (puzzle.charAt(0) - 'a'));
            //     if (freq.containsKey(s)) {
            //         total += freq.get(s);
            //     }
            // }
            // if (freq.containsKey(1 << (puzzle.charAt(0) - 'a'))) {
            //     total += freq.get(1 << (puzzle.charAt(0) - 'a'));
            // }

            ans.add(total);
        }
        return ans;
    }
}