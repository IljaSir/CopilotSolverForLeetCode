impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        if num_rows == 1 {
            return s;
        }
        let mut ans = String::new();
        let len = s.len();
        let cycle_len = 2 * num_rows - 2;
        for i in 0..num_rows {
            let mut j = 0;
            while j + i < len {
                ans.push(s.chars().nth(j + i).unwrap());
                if i != 0 && i != num_rows - 1 && j + cycle_len - i < len {
                    ans.push(s.chars().nth(j + cycle_len - i).unwrap());
                }
                j += cycle_len;
            }
        }
        ans
    }
}