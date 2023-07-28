impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let mut left = 1;
        let mut right = 1;
        let mut ans = -1;
        for i in 0..nums.len() {
            let n = nums[i];
            right *= n;
            let g = gcd(left, right);
            left /= g;
            right /= g;
            if left == 1 && right == 1 {
                ans = i as i32;
            }
        }
        ans
    }
}