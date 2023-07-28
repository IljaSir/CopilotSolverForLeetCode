impl Solution {
    pub fn sort_even_odd(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd = Vec::new();
        let mut even = Vec::new();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                even.push(nums[i]);
            } else {
                odd.push(nums[i]);
            }
        }
        even.sort();
        odd.sort_by(|a, b| b.cmp(a));
        let mut result = Vec::new();
        for i in 0..nums.len() {
            if i % 2 == 0 {
                result.push(even[i / 2]);
            } else {
                result.push(odd[(i - 1) / 2]);
            }
        }
        result
    }
}