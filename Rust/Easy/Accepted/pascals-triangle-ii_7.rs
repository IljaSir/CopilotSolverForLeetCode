impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut res: Vec<i32> = Vec::new();
        let mut row = 0;
        while row <= row_index {
            res.push(1);
            for i in (1..row).rev() {
                res[i as usize] = res[i as usize] + res[(i - 1) as usize];
            }
            row += 1;
        }
        res
    }
}