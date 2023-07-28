impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let mut res = String::new();
        let mut s = s;
        let k = k as usize;
        while s.len() > 0 {
            let (mut a, mut b) = s.split_at(k);
            if b.len() < k {
                b = "";
            }
            a = a.chars().rev().collect::<String>().as_str();
            res.push_str(a);
            res.push_str(b);
            s = s.split_off(k);
        }
        res
    }
}