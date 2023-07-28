impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let len = arr.len();
        for i in 0..len {
            let mut start = 0;
            let mut end = len - i;
            while end <= len {
                sum += arr[start..end].iter().sum::<i32>();
                start += 1;
                end += 1;
            }
        }
        sum
    }
}