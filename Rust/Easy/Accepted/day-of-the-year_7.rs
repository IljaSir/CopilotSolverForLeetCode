impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut days = 0;
        let mut is_leap_year = false;
        let date: Vec<i32> = date.split("-").map(|s| s.parse().unwrap()).collect();
        let (year, month, day) = (date[0], date[1], date[2]);
        if year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) {
            is_leap_year = true;
        }
        for i in 1..month {
            days += match i {
                1 | 3 | 5 | 7 | 8 | 10 | 12 => 31,
                4 | 6 | 9 | 11 => 30,
                2 => if is_leap_year { 29 } else { 28 },
                _ => 0,
            };
        }
        days + day
    }
}