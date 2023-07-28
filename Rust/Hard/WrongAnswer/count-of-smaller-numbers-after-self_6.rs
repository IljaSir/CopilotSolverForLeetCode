impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut vec: Vec<i32> = vec![];
        let mut res: Vec<i32> = vec![];
        for i in (0..nums.len()).rev() {
            let idx = vec.binary_search(&nums[i]).unwrap_or_else(|e| e);
            vec.insert(idx, nums[i]);
            res.push(idx as i32);
        }
        res.reverse();
        res
    }
}