impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut l = vec![0; n];
        let mut r = vec![0; n];
        l[0] = nums[0];
        for i in 1..n {
            l[i] = gcd(l[i - 1], nums[i]);
        }
        r[n - 1] = nums[n - 1];
        for i in (0..n - 1).rev() {
            r[i] = gcd(r[i + 1], nums[i]);
        }
        for i in 0..n {
            if i == 0 && r[i + 1] == 1 {
                return i as i32;
            }
            if i == n - 1 && l[i - 1] == 1 {
                return i as i32;
            }
            if i > 0 && i < n - 1 && gcd(l[i - 1], r[i + 1]) == 1 {
                return i as i32;
            }
        }
        -1
    }
}