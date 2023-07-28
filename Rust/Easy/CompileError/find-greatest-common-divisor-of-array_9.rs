impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let (min, max) = nums.iter().minmax().into_option().unwrap();
        let mut d = *min;
        while d > 1 {
            if min % d == 0 && max % d == 0 {
                return d;
            }
            d -= 1;
        }
        1
    }
}