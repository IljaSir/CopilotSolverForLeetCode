impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut l = vec![1; n];
        let mut r = vec![1; n];
        for i in 1..n {
            l[i] = gcd(l[i - 1], nums[i - 1]);
        }
        for i in (0..n - 1).rev() {
            r[i] = gcd(r[i + 1], nums[i + 1]);
        }
        for i in 0..n {
            if gcd(l[i], r[i]) == 1 {
                return i as i32;
            }
        }
        -1
    }
}