impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        if num_rows == 1 {
            return s;
        }
        let mut res = String::new();
        let len = s.len();
        let cycle_len = 2 * num_rows - 2;
        for i in 0..num_rows {
            let mut j = 0;
            while j + i < len {
                res.push(s.chars().nth(j + i as usize).unwrap());
                if i != 0 && i != num_rows - 1 && j + cycle_len - i < len {
                    res.push(s.chars().nth(j + cycle_len - i as usize).unwrap());
                }
                j += cycle_len;
            }
        }
        res
    }
}