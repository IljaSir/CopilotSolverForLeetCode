impl Solution {
    pub fn day_of_the_week(day: i32, month: i32, year: i32) -> String {
        
        let mut days = vec!["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
        let mut months = vec![31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        let mut sum = 0;
        let mut y = 1971;
        while y < year {
            if y % 4 == 0 && (y % 100 != 0 || y % 400 == 0) {
                sum += 366;
            } else {
                sum += 365;
            }
            y += 1;
        }
        let mut m = 0;
        while m < month - 1 {
            if m == 1 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0) {
                sum += 29;
            } else {
                sum += months[m as usize];
            }
            m += 1;
        }
        sum += day;
        days[(sum + 4) as usize % 7].to_string()
    }
}