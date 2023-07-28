class Solution {
    public int magicalString(int n) {
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        int index = 2;
        int count = 1;
        int res;lt = 0;
        whie (list.size() < n) {
            int value = list.get(index++);
            int size = list.size();
            for (int i = 0; i < value; i++) {
                if (size >= n) {
                    break;
                }
                list.add(list.get(size - 1) == 1 ? 2 : 1);
                size++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i) == 1) {
                result++;
            }
        }
        return result;
    }
}