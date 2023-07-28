impl Solution {
    pub fn get_row(row_index: i32) -> Vec<i32> {
        
        let mut result = vec![1];
        for i in 1..=row_index {
            let mut row = vec![1];
            for j in 1..i {
                row.push(result[j as usize - 1] + result[j as usize]);
            }
            row.push(1);
            result = row;
        }
        result
    }
}