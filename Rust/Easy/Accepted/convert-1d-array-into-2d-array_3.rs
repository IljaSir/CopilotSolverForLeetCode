impl Solution {
    pub fn construct2_d_array(original: Vec<i32>, m: i32, n: i32) -> Vec<Vec<i32>> {
        
        let m = m as usize;
        let n = n as usize;
        if original.len() != m * n {
            return Vec::new();
        }
        let mut result = Vec::new();
        let mut row = Vec::new();
        for (i, val) in original.iter().enumerate() {
            row.push(*val);
            if (i + 1) % n == 0 {
                result.push(row);
                row = Vec::new();
            }
        }
        result
    }
}