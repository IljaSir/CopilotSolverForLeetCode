impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut days = 0;
        let mut is_leap = false;
        let mut year = 0;
        let mut month = 0;
        let mut day = 0;
        for (i, c) in date.chars().enumerate() {
            if i < 4 {
                year = year * 10 + c.to_digit(10).unwrap();
            } else if i < 7 {
                month = month * 10 + c.to_digit(10).unwrap();
            } else {
                day = day * 10 + c.to_digit(10).unwrap();
            }
        }
        if year % 400 == 0 {
            is_leap = true;
        } else if year % 100 == 0 {
            is_leap = false;
        } else if year % 4 == 0 {
            is_leap = true;
        } else {
            is_leap = false;
        }
        for i in 1..month {
            if i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12 {
                days += 31;
            } else if i == 2 {
                if is_leap {
                    days += 29;
                } else {
                    days += 28;
                }
            } else {
                days += 30;
            }
        }
        days + day
    }
}