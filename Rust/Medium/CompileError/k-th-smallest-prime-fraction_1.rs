impl Solution {
    pub fn kth_smallest_prime_fraction(arr: Vec<i32>, k: i32) -> Vec<i32> {
        
        let n = arr.len();
        let mut l = 0.0;
        let mut r = 1.0;
        let mut mid = (l + r) / 2.0;
        let mut ans = vec![0, 1];
        while r - l > 0.000001 {
            let mut count = 0;
            let mut j = 1;
            for i in 0..n {
                while j < n && arr[i] as f64 / arr[j] as f64 > mid {
                    j += 1;
                }
                count += n - j;
            }
            if count < k {
                l = mid;
            } else {
                ans = vec![arr[(n - j) as usize], arr[n - 1]];
                r = mid;
            }
            mid = (l + r) / 2.0;
        }
        ans
    }
}