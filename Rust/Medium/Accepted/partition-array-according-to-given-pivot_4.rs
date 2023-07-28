impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut less = Vec::new();
        let mut equal = Vec::new();
        let mut greater = Vec::new();
        for i in 0..nums.len() {
            if nums[i] < pivot {
                less.push(nums[i]);
            } else if nums[i] > pivot {
                greater.push(nums[i]);
            } else {
                equal.push(nums[i]);
            }
        }
        less.extend(equal);
        less.extend(greater);
        less
    }
}