impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>, k: i32, threshold: i32) -> i32 {
        
        let mut sum = 0;
        for i in 0..k {
            sum += arr[i as usize];
        }
        let mut count = 0;
        if sum / k >= threshold {
            count += 1;
        }
        for i in k..arr.len() as i32 {
            sum += arr[i as usize] - arr[(i - k) as usize];
            if sum / k >= threshold {
                count += 1;
            }
        }
        count
    }
}