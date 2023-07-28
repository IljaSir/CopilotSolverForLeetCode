impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        for i in 0..arr.len() {
            for j in i..arr.len() {
                if (j - i + 1) % 2 == 1 {
                    sum += arr[i..=j].iter().sum::<i32>();
                }
            }
        }
        sum
    }
}