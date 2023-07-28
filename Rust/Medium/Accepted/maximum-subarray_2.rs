impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        

        let mut max = i32::MIN;
        let mut sum = 0;
        for n in nums {
            sum += n;
            if sum > max {
                max = sum;
            }
            if sum < 0 {
                sum = 0;
            }
        }
        max
    }
}