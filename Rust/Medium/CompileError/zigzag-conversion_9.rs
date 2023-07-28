impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        let mut res = String::new();
        let s = s.as_bytes();
        let len = s.len();
        if num_rows == 1 || len <= 1 {
            return s.iter().map(|&x| x as char).collect();
        }
        let num_rows = num_rows as usize;
        let mut rows = vec![Vec::new(); num_rows];
        let mut i = 0;
        let mut flag = false;
        for &c in s {
            rows[i].push(c);
            if i == 0 || i == num_rows - 1 {
                flag = !flag;
            }
            i = if flag { i + 1 } else { i - 1 };
        }
        for row in rows {
            res.extend(row);
        }
        res
    }
}