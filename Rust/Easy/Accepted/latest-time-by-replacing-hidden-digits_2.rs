impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut time = time;
        if time.chars().nth(0).unwrap() == '?' {
            if time.chars().nth(1).unwrap() == '?' || time.chars().nth(1).unwrap() <= '3' {
                time.replace_range(0..1, "2");
            } else {
                time.replace_range(0..1, "1");
            }
        }

        if time.chars().nth(1).unwrap() == '?' {
            if time.chars().nth(0).unwrap() == '2' {
                time.replace_range(1..2, "3");
            } else {
                time.replace_range(1..2, "9");
            }
        }

        if time.chars().nth(3).unwrap() == '?' {
            time.replace_range(3..4, "5");
        }

        if time.chars().nth(4).unwrap() == '?' {
            time.replace_range(4..5, "9");
        }

        time
    }
}