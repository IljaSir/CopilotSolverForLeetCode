impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        

        if num_rows == 1 {
            return s;
        }
        let mut res = vec![Vec::new(); num_rows as usize];
        let mut row = 0;
        let mut down = true;
        for c in s.chars() {
            res[row].push(c);
            if down {
                row += 1;
            } else {
                row -= 1;
            }
            if row == 0 || row == num_rows - 1 {
                down = !down;
            }
        }
        res.iter().flatten().collect()
    }
}