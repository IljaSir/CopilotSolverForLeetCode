impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let n = arr.len();
        let mut sum = 0;
        let mut max = 0;
        let mut total = 0;
        let mut max_total = 0;
        for i in 0..n {
            sum += arr[i];
            if sum > max {
                max = sum;
            }
            if sum < 0 {
                sum = 0;
            }
            total += arr[i];
            if total > max_total {
                max_total = total;
            }
        }
        if k == 1 {
            return max as i32;
        }
        if total <= 0 {
            return max as i32;
        }
        let mut sum = 0;
        let mut max = 0;
        for i in 0..n {
            sum += arr[i];
            if sum > max {
                max = sum;
            }
            if sum < 0 {
                sum = 0;
            }
        }
        let mut sum = 0;
        let mut max2 = 0;
        for i in (0..n).rev() {
            sum += arr[i];
            if sum > max2 {
                max2 = sum;
            }
            if sum < 0 {
                sum = 0;
            }
        }
        let mut res = max + max2;
        if res < max {
            res = max;
        }
        if res < max_total {
            res = max_total;
        }
        if res < max_total + total * (k - 2) {
            res = max_total + total * (k - 2);
        }
        return (res % (1000000007)) as i32;
    }
}