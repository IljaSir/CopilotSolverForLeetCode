class Solution {
    public boolean isRationalEqual(String s, String t) {
        
        String[] ss = s.split("\\.");
        String[] ts = t.split("\\.");
        String[] sr = ss[1].split("\\(");
        String[] tr = ts[1].split("\\(");
        String[] srr = sr.length > 1 ? sr[1].split("\\)") : new String[] {""};
        String[] trr = tr.length > 1 ? tr[1].split("\\)") : new String[] {""};
        int srrLen = srr[0].length();
        int trrLen = trr[0].length();
        int srrCnt = sr.length > 1 ? Integer.parseInt(srr[0]) : 0;
        int trrCnt = tr.length > 1 ? Integer.parseInt(trr[0]) : 0;
        int srrMax = sr.length > 1 ? Integer.parseInt(srr[1]) : 0;
        int trrMax = tr.length > 1 ? Integer.parseInt(trr[1]) : 0;
        int srrMin = sr.length > 1 ? Math.min(srrCnt, srrMax) : 0;
        int trrMin = tr.length > 1 ? Math.min(trrCnt, trrMax) : 0;
        int srrDiff = srrCnt - srrMin;
        int trrDiff = trrCnt - trrMin;
        int srrDiffCnt = srr.length > 1 ? srr[1].length() : 0;
        int trrDiffCnt = trr.length > 1 ? trr[1].length() : 0;
        int srrDiffMax = sr.length > 1 ? Integer.parseInt(srr[1]) : 0;
        int trrDiffMax = tr.length > 1 ? Integer.parseInt(trr[1]) : 0;
        int srrDiffMin = sr.length > 1 ? Math.min(srrDiffCnt, srrDiffMax) : 0;
        int trrDiffMin = tr.length > 1 ? Math.min(trrDiffCnt, trrDiffMax) : 0;
        int srrDiffDiff = srrDiffCnt - srrDiffMin;
        int trrDiffDiff = trrDiffCnt - trrDiffMin;
        int srrDiffDiffMax = sr.length > 1 ? Integer
    }
}