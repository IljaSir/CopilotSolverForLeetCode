impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut min = 0;
        let mut m = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum - min);
            min = std::cmp::min(min, sum);
            m = std::cmp::max(m, arr[i]);
        }
        let mut res = max;
        if k > 1 {
            res = std::cmp::max(res, max + sum * (k - 2));
        }
        if sum > 0 {
            res = std::cmp::max(res, max + sum * (k - 1));
        }
        if m < 0 {
            res = m;
        }
        (res % 1000000007) as i32
    }
}