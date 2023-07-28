impl Solution {
    pub fn max_sum_submatrix(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = matrix.len();
        let n = matrix[0].len();
        let mut ret = i32::MIN;
        for i in 0..m {
            let mut sum = vec![0; n];
            for j in i..m {
                for c in 0..n {
                    sum[c] += matrix[j][c];
                }
                let mut set = std::collections::BTreeSet::new();
                set.insert(0);
                let mut cur = 0;
                for x in sum.iter() {
                    cur += x;
                    if let Some(&y) = set.range(cur - k..).next() {
                        ret = ret.max(cur - y);
                    }
                    set.insert(cur);
                }
            }
        }
        ret
    }
}