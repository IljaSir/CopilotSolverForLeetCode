impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut login_time = login_time.split(":").map(|x| x.parse().unwrap()).collect::<Vec<i32>>();
        let mut logout_time = logout_time.split(":").map(|x| x.parse().unwrap()).collect::<Vec<i32>>();
        let m
    }
}