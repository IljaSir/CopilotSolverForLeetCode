impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut result = 0;
        let mut time = time;
        let mut i = 0;
        while i < time.len() {
            if time.chars().nth(i).unwrap() == '?' {
                if i == 0 {
                    if time.chars().nth(i + 1).unwrap() == '?' {
                        result += 24 * 60;
                    } else {
                        if time.chars().nth(i + 1).unwrap() <= '3' {
                            result += 20 * 60;
                        } else {
                            result += 10 * 60;
                        }
                    }
                } else if i == 1 {
                    if time.chars().nth(i - 1).unwrap() == '?' {
                        result += 24 * 60;
                    } else {
                        if time.chars().nth(i - 1).unwrap() == '0' || time.chars().nth(i - 1).unwrap() == '1' {
                            result += 10 * 60;
                        } else {
                            result += 4 * 60;
                        }
                    }
                } else if i == 3 {
                    result += 6 * 10;
                } else if i == 4 {
                    result += 10;
                }
            }
            i += 1;
        }
        result
    }
}