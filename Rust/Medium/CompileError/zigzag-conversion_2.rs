impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        if num_rows == 1 {
            return s;
        }
        let mut res = String::new();
        let n = s.len();
        let cycle = 2 * num_rows - 2;
        for i in 0..num_rows {
            let mut j = 0;
            while j + i < n {
                res.push(s.chars().nth(j + i as usize).unwrap());
                if i != 0 && i != num_rows - 1 && j + cycle - i < n {
                    res.push(s.chars().nth(j + cycle - i as usize).unwrap());
                }
                j += cycle;
            }
        }
        res
    }
}