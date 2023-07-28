impl Solution {
    pub fn base_neg2(n: i32) -> String {
        
        let mut n = n as u32;
        let mut res = String::new();
        while n > 0 {
            res.push_str(&(n % 2).to_string());
            n /= 2;
        }
        res
    }
}