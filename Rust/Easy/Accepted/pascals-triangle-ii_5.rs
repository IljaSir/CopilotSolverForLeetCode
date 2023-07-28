impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut row = vec![1; (row_index + 1) as usize];
        for i in 1..row_index {
            let mut prev = 1;
            for j in 1..i + 1 {
                let t = row[j as usize];
                row[j as usize] = row[j as usize] + prev;
                prev = t;
            }
        }
        row
    }
}