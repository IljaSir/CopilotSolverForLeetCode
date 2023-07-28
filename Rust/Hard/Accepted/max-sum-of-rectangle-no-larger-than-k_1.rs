impl Solution {
    pub fn max_sum_submatrix(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let (m, n) = (matrix.len(), matrix[0].len());
        let mut ans = std::i32::MIN;
        for i in 0..m {
            let mut sum = vec![0; n];
            for j in i..m {
                for c in 0..n {
                    sum[c] += matrix[j][c];
                }
                let mut set = std::collections::BTreeSet::new();
                set.insert(0);
                let mut cur = 0;
                for &v in &sum {
                    cur += v;
                    if let Some(&it) = set.range(cur - k..).next() {
                        ans = ans.max(cur - it);
                    }
                    set.insert(cur);
                }
            }
        }
        ans
    }
}