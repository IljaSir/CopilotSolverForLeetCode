impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 1;
        let mut sum = 0;
        let mut ans = 0;
        let mod_ = 1000000007;
        for i in arr {
            sum += i;
            if sum % 2 == 0 {
                ans += odd;
                ans %= mod_;
                even += 1;
            } else {
                ans += even;
                ans %= mod_;
                odd += 1;
            }
        }
        ans
    }
}