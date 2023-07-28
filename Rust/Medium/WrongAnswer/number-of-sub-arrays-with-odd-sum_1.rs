impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 1;
        let mut sum = 0;
        let mut ans = 0;
        for num in arr {
            sum += num;
            if sum % 2 == 1 {
                ans += even;
                odd += 1;
            } else {
                ans += odd;
                even += 1;
            }
        }
        ans as i32 % 1000000007
    }
}