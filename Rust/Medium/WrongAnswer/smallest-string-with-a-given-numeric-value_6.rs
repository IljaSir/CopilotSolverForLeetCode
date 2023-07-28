impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        let mut k = k;
        for i in 0..n {
            let c = (k - (n - i - 1) * 26) as u8;
            if c > 26 {
                res.push('z');
                k -= 26;
            } else {
                res.push((c + 96) as char);
                k -= c as i32;
            }
        }
        res
    }
}