impl Solution {
    pub fn num_of_subarrays(arr: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut even = 1;
        let mut odd = 0;
        let mut sum = 0;
        let modu = 1_000_000_007;
        for &x in arr.iter() {
            sum += x;
            if sum % 2 == 0 {
                res += odd;
                even += 1;
            } else {
                res += even;
                odd += 1;
            }
            res %= modu;
        }
        res
    }
}