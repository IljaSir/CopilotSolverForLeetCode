impl Solution {
    pub fn max_sum_submatrix(matrix: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let m = matrix.len();
        if m == 0 {
            return 0;
        }
        let n = matrix[0].len();
        if n == 0 {
            return 0;
        }
        let mut ans = std::i32::MIN;
        for i in 0..m {
            let mut sum = vec![0; n];
            for j in i..m {
                for c in 0..n {
                    sum[c] += matrix[j][c];
                }
                ans = ans.max(Self::max_sum_subarray(&sum, k));
            }
        }
        ans
    }
    fn max_sum_subarray(nums: &[i32], k: i32) -> i32 {
        let mut ans = std::i32::MIN;
        let mut sum = 0;
        let mut set = std::collections::BTreeSet::new();
        set.insert(0);
        for num in nums {
            sum += num;
            if let Some(&x) = set.range(sum - k..).next() {
                ans = ans.max(sum - x);
            }
            set.insert(sum);
        }
        ans
    }
}