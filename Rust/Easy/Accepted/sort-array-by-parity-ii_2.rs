impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd = Vec::new();
        let mut even = Vec::new();
        for i in nums {
            if i % 2 == 0 {
                even.push(i);
            } else {
                odd.push(i);
            }
        }
        let mut result = Vec::new();
        for i in 0..even.len() {
            result.push(even[i]);
            result.push(odd[i]);
        }
        result
    }
}