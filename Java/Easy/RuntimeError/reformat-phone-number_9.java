class Solution {
    public String reformatNumber(String number) {
        
        number = number.replace(" ", "").replace("-", "");
        int length = number.length();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            if (length - index >= 4) {
                sb.append(number.substring(index, index + 3)).append("-");
                index += 3;
            } else if (length - index == 3) {
                sb.append(number.substring(index, index + 3));
                index += 3;
            } else {
                sb.append(number.substring(index, index + 2));
                index += 2;
            }
        }
        return sb.toString();
    }
}