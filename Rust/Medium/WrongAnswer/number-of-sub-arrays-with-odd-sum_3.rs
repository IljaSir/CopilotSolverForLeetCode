impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 1;
        let mut sum = 0;
        let mut res = 0;
        for num in arr {
            sum += num;
            if sum % 2 == 0 {
                res += odd;
                even += 1;
            } else {
                res += even;
                odd += 1;
            }
        }
        (res % 1000000007) as i32
    }
}