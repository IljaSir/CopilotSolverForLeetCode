class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            List<Integer> pile = piles.get(i);
            for (int j = 0; j < pile.size(); j++) {
                list.add(pile.get(j));
            }
        }
        Collections.sort(list);
        int n = list.size();
        int i = 0;
        int j = n - 1;
        int ans = 0;
        while (k > 0) {
            ans += list.get(j);
            k--;
            j--;
            if (k > 0) {
                i++;
                k--;
            }
        }
        return ans;
    }
}