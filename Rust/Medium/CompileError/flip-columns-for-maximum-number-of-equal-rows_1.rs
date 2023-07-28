impl Solution {
    pub fn max_equal_rows_after_flips(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for row in matrix {
            let mut x = 0;
            let mut y = 0;
            for i in 0..row.len() {
                if row[i] == 0 {
                    x += 1 << i;
                } else {
                    y += 1 << i;
                }
            }
            *map.entry(x).or_insert(0) += 1;
            *map.entry(y).or_insert(0) += 1;
        }
        map.values().max().unwrap_or(&0).clone() as i32
    }
}