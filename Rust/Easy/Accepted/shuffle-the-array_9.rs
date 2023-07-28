impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        
        let mut out = Vec::new();
        let mut i = 0;
        let mut j = n as usize;
        while i < n as usize {
            out.push(nums[i]);
            out.push(nums[j]);
            i += 1;
            j += 1;
        }
        out
    }
}