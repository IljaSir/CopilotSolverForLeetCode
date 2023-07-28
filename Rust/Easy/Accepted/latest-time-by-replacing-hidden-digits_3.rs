impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut result = String::from(time);
        if result.chars().nth(0).unwrap() == '?' {
            if result.chars().nth(1).unwrap() == '?' || result.chars().nth(1).unwrap() <= '3' {
                result.replace_range(0..1, "2");
            } else {
                result.replace_range(0..1, "1");
            }
        }
        if result.chars().nth(1).unwrap() == '?' {
            if result.chars().nth(0).unwrap() == '2' {
                result.replace_range(1..2, "3");
            } else {
                result.replace_range(1..2, "9");
            }
        }
        if result.chars().nth(3).unwrap() == '?' {
            result.replace_range(3..4, "5");
        }
        if result.chars().nth(4).unwrap() == '?' {
            result.replace_range(4..5, "9");
        }
        result
    }
}