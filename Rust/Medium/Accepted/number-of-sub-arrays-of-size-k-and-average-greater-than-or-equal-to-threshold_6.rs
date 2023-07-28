impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut sum = arr[0..k as usize].iter().sum::<i32>();
        let mut count = if sum / k >= threshold { 1 } else { 0 };
        for i in 0..arr.len() - k as usize {
            sum = sum - arr[i] + arr[i + k as usize];
            if sum / k >= threshold {
                count += 1;
            }
        }
        count
    }
}