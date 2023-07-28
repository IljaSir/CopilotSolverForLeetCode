class Solution {
    public boolean judgePoint24(int[] cards) {
        
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return judgePoint24(list);
    }

    private boolean judgePoint24(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) < 1e-6;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == 0) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == 1) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == 2) {
                            list2.add(list.get(i) - list.get(j));
                        } else {
                            if (Math.abs(list.get(j)) < 1e-6) {
                                continue;
                            }
                            list2.add(list.get(i) / list.get(j));
                        }
                        if (judgePoint24(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}