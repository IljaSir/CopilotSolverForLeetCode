impl Solution {
    pub fn increasing_triplet(nums: Vec<i32>) -> bool {
        

        let mut min1 = i32::MAX;
        let mut min2 = i32::MAX;
        for n in nums {
            if n <= min1 {
                min1 = n;
            } else if n <= min2 {
                min2 = n;
            } else {
                return true;
            }
        }
        false
    }
}