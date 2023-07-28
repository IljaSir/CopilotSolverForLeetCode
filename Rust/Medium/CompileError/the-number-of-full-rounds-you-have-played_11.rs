impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let (login_hour, login_min) = Self::get_hour_and_min(&login_time);
        let (logout_hour, logout_min) = Self::get_hour_and_min(&logout_time);
        let mut login_time_in_min = login_hour * 60 + login_min;
        let logout_time_in_min = logout_hour * 60 + logout_min;
        if login_time_in_min > logout_time_in_min {
            login_time_in_min -= 24 * 60;
        }
        let mut start_round = login_time_in_min / 15;
        let end_round = logout_time_in_min / 15;
        if login_time_in_min % 15 == 0 {
            start_round += 1;
        }
        if logout_time_in_min % 15 == 0 {
            end_round - start_round
        } else {
            end_rd - star_round - 1
        }
        let mut login_time = login_time.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut login_time = login_time[0] * 60 + login_time[1];
        let mut logout_time = logout_time[0] * 60 + logout_time[1];
        if login_time > logout_time {
            logout_time += 24 * 60;
        }
        let mut res = (logout_time - login_time) / 15;
        if login_time % 15 != 0 {
            res -= 1;
        }
        res
    }
}