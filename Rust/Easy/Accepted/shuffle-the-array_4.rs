impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        
        let n = n as usize;
        let mut ret = Vec::new();
        for i in 0..n {
            ret.push(nums[i]);
            ret.push(nums[i + n]);
        }
        ret
    }
}