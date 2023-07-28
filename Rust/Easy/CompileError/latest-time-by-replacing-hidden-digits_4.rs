impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut time = time;
        if time.as_bytes()[0] == '?' as u8 {
            if time.as_bytes()[1] == '?' as u8 || time.as_bytes()[1] < '4' as u8 {
                time.as_bytes_mut()[0] = '2' as u8;
            } else {
                time.as_bytes_mut()[0] = '1' as u8;
            }
        }
        if time.as_bytes()[1] == '?' as u8 {
            if time.as_bytes()[0] == '2' as u8 {
                time.as_bytes_mut()[1] = '3' as u8;
            } else {
                time.as_bytes_mut()[1] = '9' as u8;
            }
        }
        if time.as_bytes()[3] == '?' as u8 {
            time.as_bytes_mut()[3] = '5' as u8;
        }
        if time.as_bytes()[4] == '?' as u8 {
            time.as_bytes_mut()[4] = '9' as u8;
        }
        time
    }
}