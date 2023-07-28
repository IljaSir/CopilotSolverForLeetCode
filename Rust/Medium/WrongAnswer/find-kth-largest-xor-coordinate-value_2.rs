impl Solution {
    pub fn kth_largest_value(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let mut v = Vec::new();
        let mut m = Vec::new();
        let mut n = Vec::new();
        for i in 0..matrix.len() {
            m.push(vec![0; matrix[i].len()]);
            n.push(vec![0; matrix[i].len()]);
        }
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                let mut t = matrix[i][j];
                if i > 0 {
                    t ^= m[i-1][j];
                }
                if j > 0 {
                    t ^= n[i][j-1];
                }
                if i > 0 && j > 0 {
                    t ^= m[i-1][j-1];
                }
                m[i][j] = t;
                if i == 0 && j == 0 {
                    n[i][j] = t;
                } else if i == 0 {
                    n[i][j] = n[i][j-1] ^ t;
                } else if j == 0 {
                    n[i][j] = n[i-1][j] ^ t;
                } else {
                    n[i][j] = n[i-1][j] ^ n[i][j-1] ^ n[i-1][j-1] ^ t;
                }
                v.push(t);
            }
        }
        v.sort();
        v[v.len()-k as usize]
    }
}