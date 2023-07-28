impl Solution {
    pub fn k_concatenation_max_sum(arr: Vec<i32>, k: i32) -> i32 {
        
        let mut max = 0;
        let mut sum = 0;
        let mut max_sum = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum > max_sum {
                max_sum = sum;
            }
            if sum < 0 {
                sum = 0;
            }
        }
        max = max_sum;
        if k > 1 {
            sum = 0;
            for i in 0..arr.len() {
                sum += arr[i];
                if sum > max_sum {
                    max_sum = sum;
                }
                if sum < 0 {
                    sum = 0;
                }
            }
            max += max_sum;
            if sum > 0 {
                max += sum * (k - 2);
            }
        }
        let mod_num = 1000000007;
        (max % mod_num) as i32
    }
}