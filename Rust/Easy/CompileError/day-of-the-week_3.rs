impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut days = 0;
        for y in 1971..year {
            days += if Self::is_leap(y) {366} else {365};
        }
        for m in 1..month {
            days += match m {
                4 | 6 | 9 | 11 => 30,
                2 => if Self::is_leap(year) {29} else {28},
                _ => 31,
            };
        }
        days += day - 1;
        let week = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        week[(days % 7) as usize].to_string()
    }
}