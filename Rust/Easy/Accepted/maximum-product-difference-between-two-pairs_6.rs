impl Solution {
    pub fn max_product_difference(nums: Vec<i32>) -> i32 {
        
        let (mut a, mut b, mut c, mut d) = (0, 0, i32::MAX, i32::MAX);
        for i in 0..nums.len() {
            if nums[i] > a {
                b = a;
                a = nums[i];
            } else if nums[i] > b {
                b = nums[i];
            }
            if nums[i] < c {
                d = c;
                c = nums[i];
            } else if nums[i] < d {
                d = nums[i];
            }
        }
        a * b - c * d
    }
}