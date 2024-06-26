impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd: Vec<i32> = Vec::new();
        let mut even: Vec<i32> = Vec::new();
        for i in nums {
            if i % 2 == 0 {
                even.push(i);
            } else {
                odd.push(i);
            }
        }
        even.append(&mut odd);
        even
    }
}