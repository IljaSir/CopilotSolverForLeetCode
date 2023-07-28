class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        
        int loginHour = Integer.parseInt(loginTime.substring(0,2));
        int loginMin = Integer.parseInt(loginTime.substring(3,5));
        int logoutHour = Integer.parseInt(logoutTime.substring(0,2));
        int logoutMin = Integer.parseInt(logoutTime.substring(3,5));
        int loginRound = 0;
        int logoutRound = 0;
        if(loginMin >= 0 && loginMin <= 14){
            loginRound = loginHour * 4;
        }
        else if(loginMin >= 15 && loginMin <= 29){
            loginRound = loginHour * 4 + 1;
        }
        else if(loginMin >= 30 && loginMin <= 44){
            loginRound = loginHour * 4 + 2;
        }
        else if(loginMin >= 45 && loginMin <= 59){
            loginRound = loginHour * 4 + 3;
        }
        if(logoutMin >= 0 && logoutMin <= 14){
            logoutRound = logoutHour * 4;
        }
        else if(logoutMin >= 15 && logoutMin <= 29){
            logoutRound = logoutHour * 4 + 1;
        }
        else if(logoutMin >= 30 && logoutMin <= 44){
            logoutRound = logoutHour * 4 + 2;
        }
        else if(logoutMin >= 45 && logoutMin <= 59){
            logoutRound = logoutHour * 4 + 3;
        }
        if(loginHour > logoutHour){
            logoutRound += 96;
        }
        return Math.max(0, logoutRound - loginRound);
    }
}