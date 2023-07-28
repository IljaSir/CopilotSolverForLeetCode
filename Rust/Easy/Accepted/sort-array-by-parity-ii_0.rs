impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd = Vec::new();
        let mut even = Vec::new();
        for num in nums {
            if num % 2 == 0 {
                even.push(num);
            } else {
                odd.push(num);
            }
        }
        let mut result = Vec::new();
        for i in 0..(odd.len()) {
            result.push(even[i]);
            result.push(odd[i]);
        }
        result
    }
}