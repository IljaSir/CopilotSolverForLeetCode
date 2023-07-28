impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login_time = login_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        if login_time[0] > logout_time[0] {
            logout_time[0] += 24;
        }
        if login_time[0] == logout_time[0] && login_time[1] > logout_time[1] {
            logout_time[0] += 24;
        }
        let login_time = login_time[0] * 60 + login_time[1];
        let logout_time = logout_time[0] * 60 + logout_time[1];
        let mut res = 0;
        for i in login_time..logout_time {
            if i % 15 == 0 {
                res += 1;
            }
        }
        res
    }
}