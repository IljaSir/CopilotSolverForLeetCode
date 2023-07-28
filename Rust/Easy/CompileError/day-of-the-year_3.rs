impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut days = 0;
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
        for i in 1..month {
            days += match i {
                1 | 3 | 5 | 7 | 8 | 10 | 12 => 31,
                4 | 6 | 9 | 11 => 30,
                2 => if (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 {
                    29
                } else {
                    28
                },
                _ => 0,
            };
        }
        days + day
    }
}