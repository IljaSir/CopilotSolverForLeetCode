impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login = login_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        let mut logout = logout_time.split(":").map(|x| x.parse::<i32>().unwrap()).collect::<Vec<i32>>();
        if login[0] > logout[0] || (login[0] == logout[0] && login[1] > logout[1]) {
            logout[0] += 24;
        }
        let mut rounds = 0;
        if login[1] % 15 != 0 {
            login[1] += 15 - login[1] % 15;
        }
        rounds += (logout[1] - login[1]) / 15;
        rounds += (logout[0] - login[0]) * 4;
        rounds
    }
}