class Solution {
    public String removeDigit(String number, char digit) {
        
        int i = 0;
        StringBuilder sb = new StringBuilder(number);
        while (i < sb.length()) {
            if (sb.charAt(i) == digit) {
                sb.deleteCharAt(i);
                break;
            }
            i++;
        }
        return sb.toString();
    }
    public String removeDigit2(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
    public String removeDigit3(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
    public String removeDigit4(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
    public String removeDigit5(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
    public String removeDigit6(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
    public String removeDigit7(String number, char digit) {
        int i = 0;
        while (i < number.length()) {
            if (number.charAt(i) == digit) {
                number = number.substring(0, i) + number.substring(i+1);
                break;
            }
            i++;
        }
        return number;
    }
}