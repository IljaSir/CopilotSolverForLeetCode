impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut s = s;
        let mut res = vec![];
        let k = k as usize;
        while s.len() > k {
            res.push(s[..k].to_string());
            s = s[k..].to_string();
        }
        res.push(s + &fill.to_string().repeat(k-s.len()));
        res
    }
}