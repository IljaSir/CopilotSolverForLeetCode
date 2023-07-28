impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut s = s;
        let mut res = String::new();
        let mut v = Vec::new();
        for i in 0..indices.len() {
            v.push((indices[i], s.chars().nth(i).unwrap()));
        }
        v.sort();
        for i in 0..v.len() {
            res.push(v[i].1);
        }
        res
    }
}