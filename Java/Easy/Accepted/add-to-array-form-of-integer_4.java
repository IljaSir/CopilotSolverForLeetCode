class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        
        int i = num.length - 1;
        List<Integer> res = new ArrayList<Integer>();
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            res.add(k % 10);
            k /= 10;
            i--;
        }
        Collections.reverse(res);
        return res;
    }
}