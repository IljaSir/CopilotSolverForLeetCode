impl Solution {
    pub fn take_characters(s: String, k: i32) -> i32 {
        
        let mut a = 0;
        let mut b = 0;
        let mut c = 0;
        let k = k as usize;
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            let a1 = s.as_bytes()[i] as char;
            let b1 = s.as_bytes()[j] as char;
            if a1 == b1 {
                if a1 == 'a' {
                    a += 1;
                } else if a1 == 'b' {
                    b += 1;
                } else {
                    c += 1;
                }
                i += 1;
                j -= 1;
            } else {
                break;
            }
        }
        if a >= k && b >= k && c >= k {
            return (i + s.len() - 1 - j) as i32;
        }
        -1
    }
}