impl Solution {
    pub fn sorted_squares(nums: Vec<i32>) -> Vec<i32> {
        
        let mut res = Vec::new();
        for i in nums {
            res.push(i * i);
        }
        res.sort();
        res
    }
}