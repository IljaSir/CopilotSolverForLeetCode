impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut time = time;
        let mut chars = time.chars();
        let mut ch = chars.next().unwrap();
        if ch == '?' {
            let ch2 = chars.next().unwrap();
            if ch2 == '?' || ch2 < '4' {
                time.replace_range(0..1, "2");
            } else {
                time.replace_range(0..1, "1");
            }
        }
        ch = chars.next().unwrap();
        if ch == '?' {
            let ch2 = chars.next().unwrap();
            if time.as_bytes()[0] == b'2' {
                time.replace_range(1..2, "3");
            } else {
                time.replace_range(1..2, "9");
            }
        }
        ch = chars.next().unwrap();
        if ch == '?' {
            time.replace_range(3..4, "5");
        }
        ch = chars.next().unwrap();
        if ch == '?' {
            time.replace_range(4..5, "9");
        }
        time
    }
}