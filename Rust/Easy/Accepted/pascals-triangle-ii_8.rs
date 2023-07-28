impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut row = vec![1];
        for i in 0..row_index {
            row = Self::next_row(&row);
        }
        row
    }
    
    fn next_row(row: &[i32]) -> Vec<i32> {
        let mut next = vec![1];
        for i in 1..row.len() {
            next.push(row[i-1] + row[i]);
        }
        next.push(1);
        next
    }
}