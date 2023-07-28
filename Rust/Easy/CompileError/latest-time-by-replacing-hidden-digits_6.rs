impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut time = time;
        let mut i = 0;
        for c in time.chars() {
            if c == '?' {
                if i == 0 {
                    if time.chars().nth(1) == Some('?') || time.chars().nth(1) == Some('0') || time.chars().nth(1) == Some('1') || time.chars().nth(1) == Some('2') || time.chars().nth(1) == Some('3') {
                        time.replace_range(i..i+1, "2");
                    } else {
                        time.replace_range(i..i+1, "1");
                    }
                } else if i == 1 {
                    if time.chars().nth(0) == Some('2') {
                        time.replace_range(i..i+1, "3");
                    } else {
                        time.replace_range(i..i+1, "9");
                    }
                } else if i == 3 {
                    time.replace_range(i..i+1, "5");
                } else if i == 4 {
                    time.replace_range(i..i+1, "9");
                }
            }
            i += 1;
        }
        time
    }
}