impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        
        let mut res = String::new();
        let mut k = k;
        for i in 0..n-1 {
            let mut c = k - n + i + 1;
            if c > 26 {
                c = 26;
            }
            res.push((c + 96) as u8 as char);
            k -= c;
        }
        res.push((k + 96) as u8 as char);
        res
    }
}