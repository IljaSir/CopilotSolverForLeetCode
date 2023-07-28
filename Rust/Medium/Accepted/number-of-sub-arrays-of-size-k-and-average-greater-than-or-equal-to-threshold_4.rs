impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut sum = 0;
        for i in 0..k as usize {
            sum += arr[i];
        }
        let mut ans = if sum / k >= threshold { 1 } else { 0 };
        for i in k as usize..arr.len() {
            sum += arr[i] - arr[i - k as usize];
            if sum / k >= threshold {
                ans += 1;
            }
        }
        ans
    }
}