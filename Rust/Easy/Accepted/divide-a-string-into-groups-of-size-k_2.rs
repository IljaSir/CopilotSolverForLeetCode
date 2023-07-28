impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut s = s;
        let k = k as usize;
        while s.len() > k {
            let (a, b) = s.split_at(k);
            res.push(a.to_string());
            s = b.to_string();
        }
        while s.len() < k {
            s.push(fill);
        }
        res.push(s);
        res
    }
}