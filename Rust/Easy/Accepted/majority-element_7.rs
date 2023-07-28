impl Solution {
    pub fn majority_element(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut res = nums[0];
        for num in nums {
            if count == 0 {
                res = num;
            }
            count += if num == res { 1 } else { -1 };
        }
        res
    }
}