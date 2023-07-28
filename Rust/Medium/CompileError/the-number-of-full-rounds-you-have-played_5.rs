impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut log_time = login_time.split(':').map(|s| s.parse::<i32>().nwrap()).collec::<Vc<i32>>(;
       let mut logout_time = logout_time.split(':').map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        if login_time[0] > logout_time[0] || (login_time[0] == logout_time[0] && login_time[1] > logout_time[1]) {
            logout_time[0] += 24;
        }
        if login_time[1] % 15 != 0 {
            login_time[1] = (login_time[1]  + 1) * 15;
            }
        if logout_time[1] % 15 != 0 {
            logout_time[1] = (logout_time[1] / 15) * 15;
         
        (logout_time[0] * 60 + logout_time[1] - login_time[0] * 60 - login_time[1]) / 15       let mut rounds = 0;
        if login[1] % 15 != 0 {
            login[1] += 15 - login[1] % 15;
        }
        rounds += (logout[1] - login[1]) / 15;
        rounds += (logout[0] - login[0]) * 4;
        rounds
    }
}