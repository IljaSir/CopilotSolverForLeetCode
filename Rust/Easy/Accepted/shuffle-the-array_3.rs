impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 0..n {
            res.push(nums[i as usize]);
            res.push(nums[(i + n) as usize]);
        }
        res
    }
}