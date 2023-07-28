impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_by_key(|&x| {
            let mut res = 0;
            let mut p = 1;
            let mut x = x;
            while x > 0 {
                res += p * mapping[(x % 10) as usize];
                p *= 10;
                x /= 10;
            }
            res
        });
        nums
    }
}