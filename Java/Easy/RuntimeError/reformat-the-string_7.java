class Solution {
    public String reformat(String s) {
        
        int len = s.length();
        char[] chars = s.toCharArray();
        int numCount = 0;
        int alphaCount = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                numCount++;
            } else {
                alphaCount++;
            }
        }
        if (Math.abs(numCount - alphaCount) > 1) {
            return "";
        }
        char[] result = new char[len];
        int numIndex = 0;
        int alphaIndex = 1;
        if (numCount > alphaCount) {
            numIndex = 1;
            alphaIndex = 0;
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                result[numIndex] = chars[i];
                numIndex += 2;
            } else {
                result[alphaIndex] = chars[i];
                alphaIndex += 2;
            }
        }
        return new String(result);
    }
}