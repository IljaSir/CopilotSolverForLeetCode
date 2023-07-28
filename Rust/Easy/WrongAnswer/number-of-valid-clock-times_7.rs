impl Solution {
    pub fn count_time(time: String) -> i32 {
        
        let mut count = 0;
        let mut time = time;
        for i in 0..2 {
            let c = time.as_bytes()[i];
            if c == b'?' {
                if i == 0 {
                    if time.as_bytes()[1] == b'?' || time.as_bytes()[1] <= b'3' {
                        count += 2;
                    } else {
                        count += 1;
                    }
                } else {
                    if time.as_bytes()[0] == b'?' || time.as_bytes()[0] < b'2' {
                        count += 4;
                    } else {
                        count += 3;
                    }
                }
            } else {
                if i == 0 {
                    if time.as_bytes()[1] == b'?' || time.as_bytes()[1] <= b'3' {
                        count += 1;
                    }
                } else {
                    if time.as_bytes()[0] == b'?' || time.as_bytes()[0] < b'2' {
                        count += 1;
                    }
                }
            }
        }
        for i in 3..5 {
            let c = time.as_bytes()[i];
            if c == b'?' {
                count += 6;
            }
        }
        count
    }
}