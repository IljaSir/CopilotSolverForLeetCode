impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut ans = 0;
        let k = k as usize;
        let threshold = threshold * k as i32;
        let mut sum = 0;
        for i in 0..k {
            sum += arr[i];
        }
        if sum >= threshold {
            ans += 1;
        }
        for i in k..arr.len() {
            sum += arr[i] - arr[i - k];
            if sum >= threshold {
                ans += 1;
            }
        }
        ans
    }
}