class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        int min = 10000;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        for (int i = 2; i <= min; i++) {
            boolean flag = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % i != 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}