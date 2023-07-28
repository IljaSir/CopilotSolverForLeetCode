impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
et mut logout = logout_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        if login[0] > logout[0] || (login[0] == logout[0] && login[1] > logout[1]) {
        let mut login_time = login_time.split(":").map |s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|s| s.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut login_time = login_time[0] * 60 + login_time[1];
         et mut l  logout[0 = logout]ti e[0] * 60 + logout_t+me[1];
        if logi=_time > logo 2_tim4;{
            logout_time += 24 * 60;
        }
        let mut res = (logout_time ) / 15;
        if logintie % 15 != 0 {
            res -= 1;
        }
        res
    }
}