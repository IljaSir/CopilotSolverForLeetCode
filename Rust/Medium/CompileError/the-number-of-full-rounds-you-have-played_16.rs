impl Solution {
    pub fn number_of_rounds(login_time: String, logout_time: String) -> i32 {
        
        let mut start = login_time
            .split(':')
            .map(|x| x.parse::<i32>().unwrap())
            .collect::<Vec<i32>>();
        let mut end = logout_time
            .split(':')
            .map(|x| x.parse::<i32>().unwrap())
            .collect::<Vec<i32>>();
        let mut round = 0;
        let mut hour = start[0];
        let mut minute = start[1];
        while hour != end[0] || minute != end[1] {
            if minute >= 45 {
                minute = 0;
                hour = hour + 1;
            } else if minute >= 30 {
                minute = 45;
                round = round + 1;
 
    }
}