class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        // create the hashmap
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        // iterate through the creators array
        for (int i = 0; i < creators.length; i++) {
            // get the creator
            String creator = creators[i];
            // get the views
            int view = views[i];
            // check if the creator is in the hashmap
            if (map.containsKey(creator)) {
                // get the list of views
                ArrayList<Integer> list = map.get(creator);
                // add the view to the list
                list.add(view);
                // put the list back into the hashmap
                map.put(creator, list);
            } else {
                // create a new list
                ArrayList<Integer> list = new ArrayList<>();
                // add the view to the list
                list.add(view);
                // put the list into the hashmap
                map.put(creator, list);
            }
        }
        // create a list of lists
        List<List<String>> result = new ArrayList<>();
        // create a max variable
        int max = 0;
        // iterate through the hashmap
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            // get the creator
            String creator = entry.getKey();
            // get the list of views
            ArrayList<Integer> list = entry.getValue();
            // create a sum variable
            int sum = 0;
            // iterate through the list
            for (int i = 0; i < list.size(); i++) {
                // add the views to the sum
                sum += list.get(i);
            }
            // check if the sum is greater than the max
            if (sum > max) {
                // clear the list of lists
                result.clear();
                // create a new list
                List<String> list2 = new ArrayList<>();
                // add the creator to the list
                list2.add(creator);
                // add the id to the list
                list2.add(ids[list.indexOf(Collections.max(list))]);
                // add the list to the list of lists
                result.add(list2);
                // set the max to the sum
                max = sum;
            } else if (sum == max) {
                // create a new list
                List<String> list2 = new ArrayList<>();
                // add the creator to the list
                list2.add(creator);
                // add
    }
}