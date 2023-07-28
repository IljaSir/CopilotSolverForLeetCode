impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut row = vec![1; row_index as usize + 1];
        for i in 1..row_index as usize {
            for j in (1..i + 1).rev() {
                row[j] += row[j - 1];
            }
        }
        row
    }
}