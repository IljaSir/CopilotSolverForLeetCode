impl Solution {
    pub fn increasing_triplet(nums: Vec<i32>) -> bool {
        

        let mut a = i32::MAX;
        let mut b = i32::MAX;
        for n in nums {
            if n <= a {
                a = n;
            } else if n <= b {
                b = n;
            } else {
                return true;
            }
        }
        false
    }
}