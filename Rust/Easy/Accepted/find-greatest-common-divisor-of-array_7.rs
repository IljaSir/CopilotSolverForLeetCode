impl Solution {
    pub fn find_gcd(nums: Vec<i32>) -> i32 {
        
        let (mut min, mut max) = (nums[0], nums[0]);
        for &num in nums.iter() {
            min = min.min(num);
            max = max.max(num);
        }
        Self::gcd(min, max)
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Self::gcd(b, a % b)
        }
    }
}