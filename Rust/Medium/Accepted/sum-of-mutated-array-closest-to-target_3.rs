impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut sum = 0;
        let mut max = 0;
        for &val in arr.iter() {
            sum += val;
            if val > max {
                max = val;
            }
        }
        if sum <= target {
            return max;
        }
        let mut left = 0;
        let mut right = max;
        let mut ans = 0;
        while left <= right {
            let mid = (left + right) / 2;
            let mut cur = 0;
            for &val in arr.iter() {
                if val > mid {
                    cur += mid;
                } else {
                    cur += val;
                }
            }
            if cur <= target {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        let mut sum1 = 0;
        let mut sum2 = 0;
        for &val in arr.iter() {
            if val > ans {
                sum1 += ans;
            } else {
                sum1 += val;
            }
            if val > ans + 1 {
                sum2 += ans + 1;
            } else {
                sum2 += val;
            }
        }
        if (target - sum1).abs() <= (target - sum2).abs() {
            return ans;
        } else {
            return ans + 1;
        }
    }
}