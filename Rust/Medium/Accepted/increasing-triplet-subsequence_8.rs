impl Solution {
    pub fn increasing_triplet(nums: Vec<i32>) -> bool {
        

        let (mut min, mut mid) = (i32::MAX, i32::MAX);
        for &num in nums.iter() {
            if num <= min {
                min = num;
            } else if num <= mid {
                mid = num;
            } else {
                return true;
            }
        }
        false
    }
}