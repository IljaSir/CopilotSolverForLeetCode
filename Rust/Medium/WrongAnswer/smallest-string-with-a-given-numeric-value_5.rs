impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut s = String::new();
        let mut n = n;
        let mut k = k;
        while n > 0 {
            let c = if k - n >= 26 {
                'z'
            } else {
                (b'a' + (k - n) as u8) as char
            };
            s.push(c);
            k -= c as i32 - 'a' as i32 + 1;
            n -= 1;
        }
        s
    }
}