class Solution {
    public List<String> cellsInRange(String s) {
        
        List<String> result = new ArrayList<>();
        // Split the string into two parts
        String[] parts = s.split(":");
        // Get the first part
        String first = parts[0];
        // Get the second part
        String second = parts[1];
        // Get the row and col of the first part
        int row1 = Integer.parseInt(first.substring(1));
        int col1 = first.charAt(0) - 'A' + 1;
        // Get the row and col of the second part
        int row2 = Integer.parseInt(second.substring(1));
        int col2 = second.charAt(0) - 'A' + 1;
        // Iterate over the range and add each cell to the result
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                result.add(getCell(j, i));
            }
        }
        // Sort the result
        Collections.sort(result);
        // Return the result
        return result;
    }
}