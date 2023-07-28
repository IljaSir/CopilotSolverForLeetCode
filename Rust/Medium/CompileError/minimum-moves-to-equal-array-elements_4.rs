impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        

        let mut min = i32::MAX;
        let mut sum = 0;
        for num in nums {
            min = min.min(num);
            sum += num;
        }
        sum - min * nums.len() as i32
    }
}