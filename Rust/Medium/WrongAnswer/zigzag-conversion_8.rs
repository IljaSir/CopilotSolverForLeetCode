impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        let mut res = String::new();
        let num_rows = num_rows as usize;
        let s = s.as_bytes();
        let len = s.len();
        let mut i = 0;
        while i < num_rows {
            let mut j = i;
            let mut is_down = false;
            while j < len {
                res.push(s[j] as char);
                if i == 0 || i == num_rows - 1 {
                    j += 2 * num_rows - 2;
                } else if is_down {
                    j += 2 * num_rows - 2 * i - 2;
                    is_down = false;
                } else {
                    j += 2 * i;
                    is_down = true;
                }
            }
            i += 1;
        }
        res
    }
}