impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login: Vec<i32> = login_time.split(':').map(|x| x.parse().unwrap()).collect();
        let mut logout: Vec<i32> = logout_time.split(':').map(|x| x.parse().unwrap()).collect();
        let mut result = 0;
        if login[0] > logout[0] || (login[0] == logout[0] && login[1] > logout[1]) {
            logout[0] += 24;
        }
        login[0] *= 60;
        logout[0] *= 60;
        login[1] = (login[1] + 14) / 15;
        logout[1] = logout[1] / 15;
        result = logout[0] + logout[1] - login[0] - login[1];
        if result < 0 {
            0
        } else {
            result
        }
    }
}