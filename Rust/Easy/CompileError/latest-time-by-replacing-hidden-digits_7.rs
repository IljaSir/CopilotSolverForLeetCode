impl Solution {
    pub fn maximum_time(time: String) -> String {
        
        let mut res = String::from(time);
        let mut ch = res.as_bytes_mut();
        if ch[0] == b'?' {
            if ch[1] == b'?' || ch[1] < b'4' {
                ch[0] = b'2';
            } else {
                ch[0] = b'1';
            }
        }
        if ch[1] == b'?' {
            if ch[0] == b'2' {
                ch[1] = b'3';
            } else {
                ch[1] = b'9';
            }
        }
        if ch[3] == b'?' {
            ch[3] = b'5';
        }
        if ch[4] == b'?' {
            ch[4] = b'9';
        }
        String::from_utf8(ch.to_vec()).unwrap()
    }
}