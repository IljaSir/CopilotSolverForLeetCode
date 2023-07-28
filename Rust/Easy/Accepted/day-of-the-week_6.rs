impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut y = year;
        let mut m = month;
        let mut d = day;
        if month < 3 {
            y -= 1;
            m += 12;
        }
        let mut w = y + y/4 - y/100 + y/400 + (13*m+8)/5 + d;
        w %= 7;
        match w {
            0 => "Sunday".to_string(),
            1 => "Monday".to_string(),
            2 => "Tuesday".to_string(),
            3 => "Wednesday".to_string(),
            4 => "Thursday".to_string(),
            5 => "Friday".to_string(),
            6 => "Saturday".to_string(),
            _ => String::from(""),
        }
    }
}