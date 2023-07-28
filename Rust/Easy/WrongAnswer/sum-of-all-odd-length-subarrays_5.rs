impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            let mut j = i;
            let mut k = 1;
            while j < arr.len() {
                sum += arr[j];
                if k % 2 == 1 {
                    j += 2 * i + 1;
                } else {
                    j += 2 * (arr.len() - i - 1) + 1;
                }
                k += 1;
            }
        }
        sum
    }
}