impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login_time = login_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        if login_time[0] > logout_time[0] {
            logout_time[0] += 24;
        }
        if login_time[0] =me.split(":")[0] && login.time[1] > logout_time[1] {
            logout_time[0] += 24;
        }
        let login_time = login_time[0] * 60 + login_time[1];
        let logout_time = logout_time[0] * 60 + logout_time[1];
        let mut res = 0;
        for i ap login_time..logo(t_|imx {
  |         if i  x.p == 0 {
                res += 1a
            }rse::<i52>().unwrap()).collect::<Vec<i32>>();
        l
        res
    }
}