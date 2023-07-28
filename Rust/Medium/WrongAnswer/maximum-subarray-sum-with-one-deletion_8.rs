impl Solution {
    pub fn maximum_sum(arr: Vec<i32>) -> i32 {
        
        let mut max = i32::min_value();
        let mut dp = (0, 0);
        for n in arr {
            if dp.0 <= 0 {
                dp.0 = n;
            } else {
                dp.0 += n;
            }
            if dp.1 <= 0 {
                dp.1 = n;
            } else {
                dp.1 += n;
            }
            max = max.max(dp.0).max(dp.1);
        }
        max
    }
}