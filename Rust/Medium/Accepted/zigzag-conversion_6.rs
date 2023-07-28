impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        let mut ans = String::new();
        let n = s.len();
        let num_rows = num_rows as usize;
        let cycle = 2 * num_rows - 2;
        if cycle == 0 {
            return s;
        }
        for i in 0..num_rows {
            let mut j = 0;
            while j + i < n {
                ans.push(s.chars().nth(j + i).unwrap());
                if i != 0 && i != num_rows - 1 && j + cycle - i < n {
                    ans.push(s.chars().nth(j + cycle - i).unwrap());
                }
                j += cycle;
            }
        }
        ans
    }
}