impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut even = Vec::new();
        let mut odd = Vec::new();
        for n in nums {
            if n % 2 == 0 {
                even.push(n);
            } else {
                odd.push(n);
            }
        }
        even.append(&mut odd);
        even
    }
}