impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login_time = login_time.split(":").map(|x| x.parse().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|x| x.parse().unwrap()).collect::<Vec<i32>>();
        let mut login_time = login_time[0] * 60 + login_time[1];
        let mut logout_time = logout_time[0] * 60 + logout_time[1];
        if login_time > logout_time {
            logout_time += 24 * 60;
        }
        login_time = (login_time + 14) / 15 * 15;
        logout_time /= 15;
        (logout_time - login_time / 15).max(0)
    }
}