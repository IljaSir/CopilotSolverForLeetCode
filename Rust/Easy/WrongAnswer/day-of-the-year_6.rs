impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut days = 0;
        let mut is_leap = false;
        let mut year = 0;
        let mut month = 0;
        let mut day = 0;
        for (i, ch) in date.chars().enumerate() {
            if i < 4 {
                year = year * 10 + ch as i32 - '0' as i32;
            } else if i < 7 {
                month = month * 10 + ch as i32 - '0' as i32;
            } else {
                day = day * 10 + ch as i32 - '0' as i32;
            }
        }
        if year % 4 == 0 {
            if year % 100 == 0 {
                if year % 400 == 0 {
                    is_leap = true;
                }
            } else {
                is_leap = true;
            }
        }
        for i in 1..month {
            if i == 2 {
                if is_leap {
                    days += 29;
                } else {
                    days += 28;
                }
            } else if i == 4 || i == 6 || i == 9 || i == 11 {
                days += 30;
            } else {
                days += 31;
            }
        }
        days + day
    }
}