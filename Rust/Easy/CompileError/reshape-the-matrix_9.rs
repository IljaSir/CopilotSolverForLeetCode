impl Solution {
    pub fn matrix_reshape(mat: Vec<Vec<i32>>, r: i32, c: i32) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        
        let mut row = Vec::new();
        for v in mat {
            for i in v {
                row.push(i);
            }
        }
        
        if row.len() != r as usize * c as usize {
            return mat;
        }
        
        let mut i = 0;
        while i < row.len() {
            result.push(row[i..i+c as usize].to_vec());
            i += c as usize;
        }
        
        result
    }
}