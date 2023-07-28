impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut s = String::new();
        let mut k = k;
        for i in (0..n).rev() {
            let mut c = k - i;
            if c > 26 {
                c = 26;
            }
            s.push((c + 96) as u8 as char);
            k -= c;
        }
        s
    }
}