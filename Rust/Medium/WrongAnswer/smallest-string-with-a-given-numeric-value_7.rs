impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut n = n;
        let mut k = k;
        let mut s = String::new();
        while n > 0 {
            let x = (k - n).min(25);
            s.push((b'a' + x as u8) as char);
            k -= x + 1;
            n -= 1;
        }
        s
    }
}