impl Solution {
    pub fn sort_array_by_parity(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in nums {
            if i % 2 == 0 {
                res.insert(0, i);
            } else {
                res.push(i);
            }
        }
        res
    }
}