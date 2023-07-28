impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut days = 0;
        let mut year = 0;
        let mut month = 0;
        let mut day = 0;
        let mut is_leap_year = false;
        let mut i = 0;
        for c in date.chars() {
            match i {
                0 => year = year * 10 + c.to_digit(10).unwrap(),
                1 => year = year * 10 + c.to_digit(10).unwrap(),
                2 => year = year * 10 + c.to_digit(10).unwrap(),
                3 => year = year * 10 + c.to_digit(10).unwrap(),
                5 => month = month * 10 + c.to_digit(10).unwrap(),
                6 => month = month * 10 + c.to_digit(10).unwrap(),
                8 => day = day * 10 + c.to_digit(10).unwrap(),
                9 => day = day * 10 + c.to_digit(10).unwrap(),
                _ => (),
            }
            i += 1;
        }
        if year % 4 == 0 {
            if year % 100 == 0 {
                if year % 400 == 0 {
                    is_leap_year = true;
                }
            } else {
                is_leap_year = true;
            }
        }
        for m in 1..month {
            match m {
                1 => days += 31,
                2 => if is_leap_year { days += 29 } else { days += 28 },
                3 => days += 31,
                4 => days += 30,
                5 => days += 31,
                6 => days += 30,
                7 => days += 31,
                8 => days += 31,
                9 => days += 30,
                10 => days += 31,
                11 => days += 30,
                12 => days += 31,
                _ => (),
            }
        }
        days + day
    }
}