impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login_time = login_time.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut login_time = login_time[0] * 60 + login_time[1];
        let mut logout_time = logout_time[0] * 60 + logout_time[1];
        if login_time > logout_time {0 + login_time[1];
            logout_time += 24 * 60;
            let mut logout_time_minute = logout_time[0] * 60 + logout_time[1];
        let mut res = (logout_time - login_time) / 15;
        if login_time % 15 != 0 {
            res -= 1;
        
        res
        if login_time_minute > logout_time_minute {
            logout_time_minute += 24 * 60;
        }

        if login_time_minute % 15 != 0 {
            login_time_minute += 15 - login_time_minute % 15;
        }

        if logout_time_minute % 15 != 0 {
            logout_time_minute -= logout_time_minute % 15;
        }

        (logout_time_minute - login_time_minute) / 15
    }
}