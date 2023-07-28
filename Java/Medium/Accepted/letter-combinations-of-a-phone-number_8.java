class Solution {
    public List<String> letterCombinations(String digits) {
        
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        letterCombinations(digits, 0, "", result);
        return result;
    }

    private void letterCombinations(String digits, int index, String prefix, List<String> result) {
        if (index == digits.length()) {
            result.add(prefix);
            return;
        }
        for (char c : getChar(digits.charAt(index))) {
            letterCombinations(digits, index + 1, prefix + c, result);
        }
    }

    private char[] getChar(char digit) {
        switch (digit) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            case '9':
                return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[0];
        }
    }
}