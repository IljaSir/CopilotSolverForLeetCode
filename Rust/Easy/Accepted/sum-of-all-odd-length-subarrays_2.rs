impl Solution {
    pub fn sum_odd_length_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let len = arr.len();
        for i in 0..len {
            for j in i..len {
                if (j - i + 1) % 2 == 1 {
                    sum += arr[i..=j].iter().sum::<i32>();
                }
            }
        }
        sum
    }
}