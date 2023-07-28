impl Solution {
    pub fn max_equal_rows_after_flips(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..matrix.len() {
            let mut row = vec![0; matrix[0].len()];
            for j in 0..matrix[0].len() {
                row[j] = if matrix[i][j] == matrix[i][0] { 0 } else { 1 };
            }
            let mut key = String::new();
            for j in 0..matrix[0].len() {
                key.push_str(&row[j].to_string());
            }
            *map.entry(key).or_insert(0) += 1;
        }
        for (_, v) in map {
            count = count.max(v);
        }
        count
    }
}