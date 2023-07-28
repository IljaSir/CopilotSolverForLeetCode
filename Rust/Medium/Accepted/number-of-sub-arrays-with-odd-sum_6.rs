impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut sum = 0;
        let mut odd = 0;
        let mut even = 1;
        let mut ans = 0;
        let mut modv = 1000000007;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum % 2 == 0 {
                ans += odd;
                even += 1;
            } else {
                ans += even;
                odd += 1;
            }
            ans %= modv;
        }
        ans
    }
}