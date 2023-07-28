impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut res = 0;
        for i in 0..n {
            sum += arr[i];
            max = max.max(sum - min);
            min = min.min(sum);
            res = res.max(max);
        }
        if k == 1 {
            return res as i32;
        }
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        for i in 0..n {
            sum += arr[i];
            max = max.max(sum - min);
            min = min.min(sum);
            res = res.max(max);
        }
        if sum > 0 {
            let mut sum = 0;
            let mut max = 0;
            let mut min = 0;
            for i in 0..n {
                sum += arr[i];
                max = max.max(sum - min);
                min = min.min(sum);
                res = res.max(max + sum * (k - 2) as i32);
            }
        }
        res as i32 % 1_000_000_007
    }
}