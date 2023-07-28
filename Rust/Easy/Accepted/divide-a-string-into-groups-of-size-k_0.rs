impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut res: Vec<String> = vec![];
        let mut tmp: String = "".to_string();
        for c in s.chars() {
            tmp.push(c);
            if tmp.len() == k as usize {
                res.push(tmp.clone());
                tmp = "".to_string();
            }
        }
        if tmp.len() > 0 {
            for _ in tmp.len()..k as usize {
                tmp.push(fill);
            }
            res.push(tmp);
        }
        res
    }
}