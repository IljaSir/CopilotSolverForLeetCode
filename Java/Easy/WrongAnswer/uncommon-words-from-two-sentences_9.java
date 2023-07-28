class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        
        String[] s1Array = s1.split(" ");
        String[] s2Array = s2.split(" ");
        ArrayList<String> uncommonList = new ArrayList<String>();
        for(String s: s1Array) {
            if(s2.contains(s)) {
                continue;
            }
            else {
                boolean isUncommon = true;
                for(String s3: s1Array) {
                    if(s3.equals(s)) {
                        continue;
                    }
                    else {
                        if(s3.equals(s)) {
                            isUncommon = false;
                            break;
                        }
                    }
                }
                if(isUncommon) {
                    uncommonList.add(s);
                }
            }
        }
        for(String s: s2Array) {
            if(s1.contains(s)) {
                continue;
            }
            else {
                boolean isUncommon = true;
                for(String s3: s2Array) {
                    if(s3.equals(s)) {
                        continue;
                    }
                    else {
                        if(s3.equals(s)) {
                            isUncommon = false;
                            break;
                        }
                    }
                }
                if(isUncommon) {
                    uncommonList.add(s);
                }
            }
        }
        String[] uncommonArray = new String[uncommonList.size()];
        for(int i = 0; i < uncommonArray.length; i++) {
            uncommonArray[i] = uncommonList.get(i);
        }
        return uncommonArray;
    }
}