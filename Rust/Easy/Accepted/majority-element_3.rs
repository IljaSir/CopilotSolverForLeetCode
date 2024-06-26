impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut majority = 0;
        for num in nums {
            if count == 0 {
                majority = num;
            }
            if num == majority {
                count += 1;
            } else {
                count -= 1;
            }
        }
        majority
    }
}