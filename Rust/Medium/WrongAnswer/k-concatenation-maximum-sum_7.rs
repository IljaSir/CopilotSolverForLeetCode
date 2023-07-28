impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        let mut max2 = 0;
        let mut min = 0;
        let mut min2 = 0;
        let mut sum2 = 0;
        let mut sum3 = 0;
        let mut max3 = 0;
        let mut min3 = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            max = std::cmp::max(max, sum);
            min = std::cmp::min(min, sum);
        }
        if k > 1 {
            for i in 0..arr.len() {
                sum2 += arr[i];
                max2 = std::cmp::max(max2, sum2);
                min2 = std::cmp::min(min2, sum2);
            }
            for i in 0..arr.len() {
                sum3 += arr[i];
                max3 = std::cmp::max(max3, sum3);
                min3 = std::cmp::min(min3, sum3);
            }
        }
        let mut res = std::cmp::max(max, max2);
        if k > 2 {
            res = std::cmp::max(res, max3 + (k - 2) * sum);
        }
        let mut res2 = std::cmp::min(min, min2);
        if k > 2 {
            res2 = std::cmp::min(res2, min3 + (k - 2) * sum);
        }
        let mut res3 = 0;
        if k > 1 {
            res3 = sum * (k - 2) + sum2 + sum3;
        }
        res = std::cmp::max(res, res3);
        res = std::cmp::max(res, res2);
        res = std::cmp::max(res, 0);
        (res % 1000000007) as i32
    }
}