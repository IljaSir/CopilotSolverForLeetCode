impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut days = 0;
        let mut y = 1971;
        while y < year {
            days += if Solution::is_leap_year(y) { 366 } else { 365 };
            y += 1;
        }
        let mut m = 1;
        while m < month {
            days += Solution::days_in_month(m, year);
            m += 1;
        }
        days += day - 1;
        let d = days % 7;
        match d {
            0 => "Sunday".to_string(),
            1 => "Monday".to_string(),
            2 => "Tuesday".to_string(),
            3 => "Wednesday".to_string(),
            4 => "Thursday".to_string(),
            5 => "Friday".to_string(),
            6 => "Saturday".to_string(),
            _ => unreachable!(),
        }
    }
    
    pub fn days_in_month(month: i32, year: i32) -> i32 {
        match month {
            1 | 3 | 5 | 7 | 8 | 10 | 12 => 31,
            4 | 6 | 9 | 11 => 30,
            2 => if Solution::is_leap_year(year) { 29 } else { 28 },
            _ => unreachable!(),
        }
    }
}