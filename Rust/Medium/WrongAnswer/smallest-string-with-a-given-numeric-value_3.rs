impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut s = String::new();
        let mut k = k;
        let mut n = n;
        while n > 0 {
            if k - 26 >= n - 1 {
                s.push('z');
                k -= 26;
            } else {
                s.push((k - n + 1 + 'a' as i32) as u8 as char);
                k -= k - n + 1;
            }
            n -= 1;
        }
        s
    }
}