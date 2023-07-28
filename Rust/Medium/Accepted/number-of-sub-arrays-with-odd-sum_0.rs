impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 1;
        let mut sum = 0;
        let mut ans = 0;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum % 2 == 1 {
                ans += even;
                odd += 1;
            } else {
                ans += odd;
                even += 1;
            }
            ans %= 1000000007;
        }
        ans
    }
}