impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut days = vec!["Sunday".to_string(),"Monday".to_string(),"Tuesday".to_string(),"Wednesday".to_string(),"Thursday".to_string(),"Friday".to_string(),"Saturday".to_string()];
        let mut year = year;
        let mut month = month;
        let mut day = day;
        if month == 1 || month == 2 {
            month += 12;
            year -= 1;
        }
        let week = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        days[week as usize].clone()
    }
}