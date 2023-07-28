impl Solution {
    pub fn construct2_d_array(original: Vec<i32>, m: i32, n: i32) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = Vec::new();
        if m * n != original.len() as i32 {
            return res;
        }
        let mut row: Vec<i32> = Vec::new();
        for (i, v) in original.iter().enumerate() {
            row.push(*v);
            if (i + 1) % n as usize == 0 {
                res.push(row);
                row = Vec::new();
            }
        }
        res
    }
}