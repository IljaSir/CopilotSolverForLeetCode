impl Solution {
    pub fn find_valid_split(nums: Vec<i32>) -> i32 {
        
        let mut res = -1;
        let mut left = nums[0];
        let mut right = nums.iter().skip(1).product();
        for i in 1..nums.len() {
            if gcd(left, right) == 1 {
                res = i as i32 - 1;
                break;
            }
            left *= nums[i];
            right /= nums[i];
        }
        res
    }
}