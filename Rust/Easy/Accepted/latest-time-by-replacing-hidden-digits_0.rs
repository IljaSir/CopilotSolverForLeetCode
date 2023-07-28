impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut time = time.into_bytes();
        if time[0] == b'?' {
            if time[1] == b'?' || time[1] < b'4' {
                time[0] = b'2';
            } else {
                time[0] = b'1';
            }
        }
        if time[1] == b'?' {
            if time[0] == b'2' {
                time[1] = b'3';
            } else {
                time[1] = b'9';
            }
        }
        if time[3] == b'?' {
            time[3] = b'5';
        }
        if time[4] == b'?' {
            time[4] = b'9';
        }
        String::from_utf8(time).unwrap()
    }
}