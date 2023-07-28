impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 1;
        let mut ans = 0;
        let modulo = 1_000_000_007;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum % 2 == 1 {
                odd += 1;
            } else {
                even += 1;
            }
            ans = (ans + odd) % modulo;
            std::mem::swap(&mut odd, &mut even);
        }
        ans
    }
}