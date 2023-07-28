impl Solution {
    pub fn restore_string(s: String, indices: Vec<i32>) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut res = s.clone();
        for (i, c) in s.into_iter().enumerate() {
            let j = indices[i] as usize;
            res[j] = c;
        }
        res.into_iter().collect()
    }
}