impl Solution {
    pub fn base_neg2(n: i32) -> String {
        
        let mut n = n;
        let mut res = String::new();
        while n != 0 {
            res.push_str(&(n & 1).to_string());
            n = -(n >> 1);
        }
        if res.len() == 0 {
            res.push('0');
        }
        res.chars().rev().collect()
    }
}