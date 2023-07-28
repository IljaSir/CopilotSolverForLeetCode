impl Solution {
    pub fn max_sum_submatrix(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = matrix.len();
        let n = matrix[0].len();
        let mut res = std::i32::MIN;
        for i in 0..n {
            let mut sum = vec![0; m];
            for j in i..n {
                for r in 0..m {
                    sum[r] += matrix[r][j];
                }
                let mut set = std::collections::BTreeSet::new();
                set.insert(0);
                let mut cur = 0;
                for s in sum {
                    cur += s;
                    if let Some(&x) = set.range(cur - k..).next() {
                        res = res.max(cur - x);
                    }
                    set.insert(cur);
                }
            }
        }
        res
    }
}