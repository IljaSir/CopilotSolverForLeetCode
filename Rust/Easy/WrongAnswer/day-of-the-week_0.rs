impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut days = 0;
        for i in 1971..year {
            if i % 4 == 0 && (i % 100 != 0 || i % 400 == 0) {
                days += 366;
            } else {
                days += 365;
            }
        }
        let mut months = vec![31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        if year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) {
            months[1] = 29;
        }
        for i in 0..month - 1 {
            days += months[i as usize];
        }
        days += day;
        days %= 7;
        let mut res = vec!["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        res[days as usize].to_string()
    }
}