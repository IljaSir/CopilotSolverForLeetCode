impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd = 1;
        let mut even = 0;
        let mut result = nums.clone();
        for item in nums {
            if item % 2 == 0 {
                result[even] = item;
                even += 2;
            } else {
                result[odd] = item;
                odd += 2;
            }
        }
        result
    }
}