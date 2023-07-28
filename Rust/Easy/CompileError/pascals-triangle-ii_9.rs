impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut result = vec![];
        let mut row = vec![1];
        for _ in 0..row_index {
            row = Self::next_row(&row);
        }
        row
    }
    fn next_row(row: &Vec<i32>) -> Vec<i32> {
        let mut result = vec![1];
        for i in 0..row.len() - 1 {
            result.push(row[i] + row[i + 1]);
        }
        result.push(1);
        result
    }
}