class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        int[] res = new int[8];
        if (n == 0) {
            return cells;
        }
        if (n == 1) {
            return nextDay(cells);
        }
        int[] firstDay = nextDay(cells);
        int[] secondDay = nextDay(firstDay);
        int[] thirdDay = nextDay(secondDay);
        int[] fourthDay = nextDay(thirdDay);
        int[] fifthDay = nextDay(fourthDay);
        int[] sixthDay = nextDay(fifthDay);
        int[] seventhDay = nextDay(sixthDay);
        int[] eighthDay = nextDay(seventhDay);
        int[] ninthDay = nextDay(eighthDay);
        int[] tenthDay = nextDay(ninthDay);
        int[] eleventhDay = nextDay(tenthDay);
        int[] twelfthDay = nextDay(eleventhDay);
        int[] thirteenthDay = nextDay(twelfthDay);
        int[] fourteenthDay = nextDay(thirteenthDay);
        int[] fifteenthDay = nextDay(fourteenthDay);
        int[] sixteenthDay = nextDay(fifteenthDay);
        int[] seventeenthDay = nextDay(sixteenthDay);
        int[] eighteenthDay = nextDay(seventeenthDay);
        int[] nineteenthDay = nextDay(eighteenthDay);
        int[] twentiethDay = nextDay(nineteenthDay);
        int[] twentyFirstDay = nextDay(twentiethDay);
        int[] twentySecondDay = nextDay(twentyFirstDay);
        int[] twentyThirdDay = nextDay(twentySecondDay);
        int[] twentyFourthDay = nextDay(twentyThirdDay);
        int[] twentyFifthDay = nextDay(twentyFourthDay);
        int[] twentySixthDay = nextDay(twentyFifthDay);
        int[] twentySeventhDay = nextDay(twentySixthDay);
        int[] twentyEighthDay = nextDay(twentySeventhDay);
        int[] twentyNinthDay = nextDay(twentyEighthDay);
        int[] thirtiethDay = nextDay(twentyNinthDay);
        int[] thirtyFirstDay = nextDay(thirtiethDay);
        int[] thirtySecondDay = nextDay(thirtyFirstDay);
        int[] thirtyThirdDay = nextDay(thirty
    }
}