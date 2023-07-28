impl Solution {
    pub fn max_score(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        nums.iter()
            .enumerate()
            .map(|(i, &x)| x + (i as i32))
            .filter(|&x| x > 0)
            .count() as i32
    }
}