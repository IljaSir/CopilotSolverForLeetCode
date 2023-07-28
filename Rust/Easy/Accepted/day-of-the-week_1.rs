impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut year = year;
        let mut month = month;
        if month == 1 || month == 2 {
            month += 12;
            year -= 1;
        }
        let c = year / 100;
        let y = year % 100;
        let w = (c / 4) - 2 * c + y + (y / 4) + (13 * (month + 1) / 5) + day - 1;
        let mut w = w % 7;
        if w < 0 {
            w += 7;
        }
        match w {
            0 => "Sunday".to_string(),
            1 => "Monday".to_string(),
            2 => "Tuesday".to_string(),
            3 => "Wednesday".to_string(),
            4 => "Thursday".to_string(),
            5 => "Friday".to_string(),
            6 => "Saturday".to_string(),
            _ => "error".to_string(),
        }
    }
}